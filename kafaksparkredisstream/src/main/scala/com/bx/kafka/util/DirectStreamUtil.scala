package com.bx.kafka.util

import org.apache.kafka.clients.consumer.ConsumerRecord
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.spark.streaming.StreamingContext
import org.apache.spark.streaming.dstream.DStream
import org.apache.spark.streaming.kafka010.{ConsumerStrategies, KafkaUtils, LocationStrategies}

/**
  * Created by superor
  * Date 2019/1/10
  */
object DirectStreamUtil {
  val FEED_BROKERS = "10.10.10.10:9092"
  val OTHER_BROKERS = ""
  val READ_MODEL_OFFSET = "latest"

  def initKafkaStream(ssc:StreamingContext,
                      appName:String,
                      topicTypes:Set[String],
                      brokerType:String
                     ): DStream[ConsumerRecord[String,String]] ={
    val brokers = if(brokerType.equals("Feed")){
      FEED_BROKERS
    }else{
      OTHER_BROKERS
    }

    val kafkaParams = Map[String,Object](
      "bootstrap.servers"->FEED_BROKERS,
      "key.serializer"-> classOf[StringDeserializer],
      "value.serializer"->classOf[StringDeserializer],
      "group.id"->appName,
      "auto.offset.reset"->READ_MODEL_OFFSET,
      "enable.auto.commit"->(true:java.lang.Boolean),
      "sasl.kerberos.service.name"->"kafka",
      "fetch.message.max.bytes"->"3145728"
    )

    val kafkaStream:DStream[ConsumerRecord[String,String]] = KafkaUtils.createDirectStream(ssc,LocationStrategies.PreferConsistent,
      ConsumerStrategies.Subscribe[String,String](topicTypes,kafkaParams))
    return kafkaStream
  }

}
