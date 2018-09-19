package com.core.thread.singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * 静态内部类实现多线程单例安全，如果遇到序列化问题，需要在序列化类中添加 readResolve 方法
 * Created by jiangkai
 * Date 2018/6/8
 */
public class StaticInnerClassSingletonThread {
    public static void main(String[] args) {
        Thread thread1 =new Thread(new ThreadInnerClass());
        Thread thread2 =new Thread(new ThreadInnerClass());
        Thread thread3 =new Thread(new ThreadInnerClass());
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class MyObjectSingle implements Serializable{
    private static class MyObjectHandler{
        private static MyObjectSingle myObjectSingle = new MyObjectSingle();
    }

    public MyObjectSingle() {
    }

    public static MyObjectSingle getInstance(){
        return MyObjectHandler.myObjectSingle;
    }
      // 添加该方法可以解决序列化导致单例失败的情况
//    public Object readResolve() throws ObjectStreamException {
//        return MyObjectHandler.myObjectSingle;
//    }
}

class ThreadInnerClass extends Thread{
    @Override
    public void run() {
        System.out.println(MyObjectSingle.getInstance().hashCode());
    }
}
