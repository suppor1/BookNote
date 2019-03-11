package com.bx.user.operate.analysis

import java.text.SimpleDateFormat
import com.bx.kafka.util.DirectStreamUtil
import com.bx.redis.util.RedisDAO
import com.bx.stream.util.ConfigUtil
import com.google.gson.Gson
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.apache.spark.SparkConf
import org.apache.spark.streaming.dstream.DStream
import org.apache.spark.streaming.{Duration, Seconds, StreamingContext}
import org.json4s.DefaultFormats
import redis.clients.jedis.Jedis

/**
  * Created by jiangkai 
  * Date 2019/1/10
  */
object UserHistoryOP {

  case class USERHISTORY(userId:String,godId:String,submitTime:String,acceptTime:String)

  implicit val formats = DefaultFormats
  val TIME_FOREMAT = "yyyy-MM-dd HH:mm:ss"

  val RECEIVING_ORDER_TIME = 15 * 60 * 1000
  val gson = new Gson()
  val time_format = new SimpleDateFormat(TIME_FOREMAT)

  val config = ConfigUtil.getUserHistoryConfig

  val HOST_NAME = config.getString("host_name")
  val HOST_PORT = config.getInt("host_port")
  val PASSWORD = config.getString("password")
  val DB = config.getInt("db")

  def main(args: Array[String]): Unit = {
    val envConfig = ConfigUtil.getUserHistoryConfig
    val appName = envConfig.getString("user_history")
    val topics = envConfig.getString("topicsSet")
    val topicSet = topics.split(",").toSet
    val batchFrequence = envConfig.getLong("batchFrequence")

    val sparkConfig = new SparkConf()
    sparkConfig.setMaster("local")
    sparkConfig.setAppName(appName)

    val batchDuration:Duration  = Seconds(batchFrequence)
    val ssc = new StreamingContext(sparkConfig,batchDuration)

    val kafkaStream:DStream[ConsumerRecord[String,String]] = DirectStreamUtil.initKafkaStream(ssc,appName,topicSet,"Feed")

    //处理业务
    process(kafkaStream,args)

    ssc.start()
    ssc.awaitTermination()
  }

  private def process(kafkaStream:DStream[ConsumerRecord[String,String]],args: Array[String])={
    val lines = kafkaStream.map(_.value().trim)

    val feeds = lines.map(f=>gson.fromJson(f,classOf[USERHISTORY]))

    val userHistoryJedis:Jedis = RedisDAO.getInstance(HOST_NAME,HOST_PORT).getResource
    userHistoryJedis.auth(PASSWORD)
    val userHistoryPipelined = userHistoryJedis.pipelined()
    userHistoryPipelined.syncAndReturnAll()

    feeds.foreachRDD(rdd =>{
      rdd.foreachPartition(pars =>processPartition(pars,userHistoryJedis))
    })
  }

  def processPartition(records:Iterator[USERHISTORY],userHistoryJedis:Jedis):Unit={

    //过滤到符合条件的数据
    val inners_15_minutes = records.filter(f=>{
      val sys_time = System.currentTimeMillis()
      val god_accept_time = getTime(f.acceptTime)
      (god_accept_time + RECEIVING_ORDER_TIME) > sys_time
    })

    //写入redis
    inners_15_minutes.foreach(row =>{
      println(row)
      //userHistoryJedis.insert2Redis(row.godId)//写入redis
    })
  }

  private def getTime(timeStr:String):Long={
    time_format.parse(timeStr).getTime
  }
}
