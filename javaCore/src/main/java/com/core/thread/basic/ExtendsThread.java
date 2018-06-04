package com.core.thread.basic;

/**
 * Created by jiangkai
 * Date 2018/5/27
 */
public class ExtendsThread extends Thread {

    @Override
    public void run() {
        System.out.println("ExtendsThread");
    }

    public static void main(String[] args) {
        ExtendsThread extendsThread = new ExtendsThread();
        extendsThread.start();
        System.out.println("main end!");
        /**
         * 从输出结果判断，线程的调用是随机的
         * main end!
         * ExtendsThread
         */
    }
}
