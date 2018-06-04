package com.core.thread.threadSignaling;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiangkai
 * Date 2018/6/1
 */
public class TowThreadSignalingBySleepWhile {

    public static void main(String[] args) {
        Service service = new Service();
        ThreadA threadA = new ThreadA(service);
        threadA.setName("A");
        threadA.start();
        ThreadB threadB = new ThreadB(service);
        threadB.setName("B");
        threadB.start();
    }
}

class Service{
    volatile private List<String> list = new ArrayList<String>();
    public void addEle(){
        try {
            list.add("jiangkai");
            for(int i=0; i<10; i++){
                System.out.println("添加了"+(1+i)+"元素");
                list.add("");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int size(){
        return list.size();
    }
}

class ThreadA extends Thread{
    private Service service;

    public ThreadA(Service service){
        this.service = service;
    }

    @Override
    public void run() {
        super.run();
        service.addEle();
    }
}

class ThreadB extends Thread{
    private Service service;

    public ThreadB(Service service){
        this.service = service;
    }

    @Override
    public void run() {
        super.run();
        try {
            while (true){
    //            System.out.println("Thread "+Thread.currentThread().getName()+" get list size："+service.size());
                if(service.size() == 5){
                    throw new InterruptedException("Thread "+Thread.currentThread().getName()+" get list size："+service.size());
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}