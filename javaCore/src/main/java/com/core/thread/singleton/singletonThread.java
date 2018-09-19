package com.core.thread.singleton;

/**
 * 单例饿汉模式+多线程
 * Created by jiangkai
 * Date 2018/6/8
 */

public class singletonThread {
    public static void main(String[] args) {
        Thread thread1 =new Thread(new GetMyObject());
        Thread thread2 =new Thread(new GetMyObject());
        Thread thread3 =new Thread(new GetMyObject());
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class MyObjectH{
    private static MyObjectH myObjectH = new MyObjectH();

    public MyObjectH() {
    }
    public static MyObjectH getInstance(){
        if(null != myObjectH){
            return myObjectH;
        }else {
            myObjectH = new MyObjectH();
            return myObjectH;
        }
    }
}

class GetMyObject extends Thread{
    @Override
    public void run() {
        System.out.println(MyObjectH.getInstance().hashCode());
    }
}
