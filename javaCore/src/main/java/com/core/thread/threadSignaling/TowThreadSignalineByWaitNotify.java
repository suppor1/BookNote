package com.core.thread.threadSignaling;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiangkai
 * Date 2018/6/2
 */
public class TowThreadSignalineByWaitNotify {
    public static void main(String[] args) throws Exception{
        Object lock = new Object();
        ThreadC threadC = new ThreadC(lock);
        threadC.start();
        Thread.sleep(30);
        ThreadD threadD = new ThreadD(lock);
        threadD.start();
    }
}

class MyList{
    private static List<String> list = new ArrayList<String>();
    public static void addList(){
        list.add("");
    }
    public static int size(){
        return list.size();
    }
 }


class ThreadC extends Thread{
    Object lock;
    public ThreadC(Object lock){
        this.lock = lock;
    }
    @Override
    public void run() {
        super.run();
        synchronized (lock){
            try {
                MyList.addList();
                if (MyList.size() != 5){
                    System.out.println("wait start....."+System.currentTimeMillis());
                    lock.wait();
                    System.out.println("wait end....."+System.currentTimeMillis());

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class ThreadD extends Thread{
    private Object lock;
    public ThreadD(Object lock){
        this.lock = lock;
    }

    @Override
    public void run() {
        super.run();
        synchronized (lock){
            for (int i=0;i<10;i++){
                MyList.addList();
                System.out.println("添加"+MyList.size()+" 个元素");
                if(MyList.size() ==5){
                    System.out.println("notify start...");
                    lock.notify();//唤醒等待改对象锁的线程
                    System.out.println("notify end....message send success.");
                }
            }
        }
    }
}

