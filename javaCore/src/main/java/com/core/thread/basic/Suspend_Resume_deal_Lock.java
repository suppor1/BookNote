package com.core.thread.basic;

/**
 * Created by jiangkai
 * Date 2018/5/27
 */
public class Suspend_Resume_deal_Lock {
    public static void main(String[] args) {
        final SynchironizedObject synchironizedObject = new SynchironizedObject();
        Thread thread1 = new Thread(){
            @Override
            public void run() {
                System.out.println(this.getName()+" start");
                System.out.println(this.getName()+"进入printString方法，且将暂停");
                synchironizedObject.printString();
            }
        };
        thread1.setName("a");
        thread1.start();

        Thread thread2 = new Thread(){
            @Override
            public void run() {
                System.out.println(this.getName()+" start");
                synchironizedObject.printString();
            }
        };
        thread2.start();
    }
}

class SynchironizedObject{
    synchronized public void printString(){
        System.out.println("Begin"+Thread.currentThread().getName());
        while (Thread.currentThread().getName().equals("a")){
            System.out.println("线程将永远暂停"+Thread.currentThread().getName());
            Thread.currentThread().suspend();
        }
        System.out.println("End"+Thread.currentThread().getName());
    }
}
