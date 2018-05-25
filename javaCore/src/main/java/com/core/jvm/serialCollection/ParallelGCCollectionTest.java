package com.core.jvm.serialCollection;

/**
 * Created by jiangkai
 * Date 2018/5/13
 * parallec collection 分为 ParNewGC ParalleclGC ParallelOldGC
 */
public class ParallelGCCollectionTest {

    public static void main(String[] args) {
//        ParNewGCTest parNewGCTest = new ParNewGCTest();
//        parNewGCTest.parNewGC();

//        ParallelGC parallelGC = new ParallelGC();
//        parallelGC.parallelGC();

        ParallelOldGC parallelOldGC = new ParallelOldGC();
        parallelOldGC.parallelOldGC();;
    }
}

/**
 * 通过 -XX:+UseParNewGC 可以指定
 * -Xms20M -Xmx20M  -Xmn10M -XX:+UseParNewGC -XX:+PrintGCDetails
 * GC 线程回收是基于多线程并行的
 *
 */
class ParNewGCTest{
    public void parNewGC(){
        int M = 1024 * 1024;
        byte[] bytes1 = new byte[2*M];
        byte[] bytes2 = new byte[2*M];
        byte[] bytes3 = new byte[2*M];
        byte[] bytes4 = new byte[2*M];
        byte[] bytes5 = new byte[2*M];
        byte[] bytes6 = new byte[2*M];
        byte[] bytes7 = new byte[2*M];
        byte[] bytes8 = new byte[2*M];
    }
}

/**
 * Server模式下的默认GC收集器
 * 通过 -XX:+UseParallelGC  -XX:ParellelGCThreads (cup和和核数小于8 则，这个值可以为 核数，如果cpu和核数大于8，3+（cpu core*5)/8)
 * -Xmn：指定young区的大小
 * young 区的 Eden，FromSpace，ToSpace 可以通过 -XX:SurvivorRatio=8 控制，表示Eden：FromSpace = 8：1
 * -Xms20M -Xmx20M  -Xmn10M -XX:+UseParallelGC -XX:ParallelGCThreads=8 -XX:+PrintGCDetails -XX:SurvivorRatio=8
 */
class ParallelGC{
    public void parallelGC(){
        int M = 1024 * 1024;
        byte[] bytes1 = new byte[2*M];
        byte[] bytes2 = new byte[2*M];
        byte[] bytes3 = new byte[2*M];
        byte[] bytes4 = new byte[2*M];
        byte[] bytes5 = new byte[2*M];
        byte[] bytes6 = new byte[2*M];
        byte[] bytes7 = new byte[2*M];
        byte[] bytes8 = new byte[2*M];
    }
}

/**
 * -XX:UseParallelOldGC 可以通过该参数设置
 * -XX:ParallelGCThreads=8 可以设置并行回收的线程数
 * 区别于： ParallelGC：清空Heap堆中的所有垃圾对象，清空Perm区中卸载的类信息，并进行压缩
 *         ParallelOldGC: 清空Heap堆部分垃圾对象，并进行部分的空间压缩
 *  -Xms20M -Xmx20M  -Xmn10M -XX:+UseParallelOldGC -XX:ParallelGCThreads=8 -XX:+PrintGCDetails
 *  线程回收是，暂停应用线程
 */
class  ParallelOldGC{
    public void parallelOldGC(){
        int M = 1024 * 1024;
        byte[] bytes1 = new byte[2*M];
        byte[] bytes2 = new byte[2*M];
        byte[] bytes3 = new byte[2*M];
        byte[] bytes4 = new byte[2*M];
        byte[] bytes5 = new byte[2*M];
        byte[] bytes6 = new byte[2*M];
        byte[] bytes7 = new byte[2*M];
        byte[] bytes8 = new byte[2*M];
    }
}
