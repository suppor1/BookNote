package com.core.thread.basic;

/**
 * Created by jiangkai
 * Date 2018/5/29
 */
public class DeadLock implements Runnable{
    private Object lock1 = new Object();
    private Object lock2 = new Object();

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public Object getLock1() {
        return lock1;
    }

    public void setLock1(Object lock1) {
        this.lock1 = lock1;
    }

    public Object getLock2() {
        return lock2;
    }

    public void setLock2(Object lock2) {
        this.lock2 = lock2;
    }

    public void run() {

        if(name.equals("a")){
            synchronized (lock1){
                System.out.println("线程"+Thread.currentThread().getName()+" 获得lock1"+" 等待获得lock2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock2){
                    System.out.println("线程"+Thread.currentThread().getName()+" 获得lock2");
                }
            }
        }
        if(name.equals("b")){
            synchronized (lock2){
                System.out.println("线程"+Thread.currentThread().getName()+" 获得lock2"+" 等待获得lock1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock1){
                    System.out.println("线程"+Thread.currentThread().getName()+" 获得lock1");
                }
            }
        }

    }
}

class Run {
    public static void main(String[] args) throws Exception{
        DeadLock deadLock = new DeadLock();
        deadLock.setName("a");
        Thread thread1 = new Thread(deadLock);
        thread1.setName("aaa");
        thread1.start();
        thread1.sleep(100);
        deadLock.setName("b");
        Thread thread2 = new Thread(deadLock);
        thread2.setName("bbb");
        thread2.start();
    }
}
