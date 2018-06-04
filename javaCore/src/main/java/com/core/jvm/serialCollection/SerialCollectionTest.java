package com.core.jvm.serialCollection;

/**
 * Created by jiangkai
 * Date 2018/5/13
 * 验证 Serial Collection
 * jvm参数： -Xms20M -Xmx20M  -Xmn10M -XX:+UseSerialGC -XX:+PrintGCDetails
 */
public class SerialCollectionTest {

    public static void main(String[] args) {
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
