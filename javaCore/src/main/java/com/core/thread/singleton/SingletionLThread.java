package com.core.thread.singleton;

/**
 * Created by jiangkai
 * Date 2018/6/8
 */
public class SingletionLThread {
    public static void main(String[] args) {
        Thread thread1 =new Thread(new GetMyObjectL());
        Thread thread2 =new Thread(new GetMyObjectL());
        Thread thread3 =new Thread(new GetMyObjectL());
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class MyObjectL{

    static MyObjectL myObjectL;

    public MyObjectL() {
    }

    public static MyObjectL getInstance(){
        try {
            if(null != myObjectL){

            }else {
                Thread.sleep(2000);
                //这种写法依然会导致线程不安全问题
//                synchronized (MyObjectL.class){
//                    myObjectL =new MyObjectL();
//                }
                //这种写法加入DCL双检查锁,可以解决线程安全问题
                synchronized (MyObjectL.class){
                    if(null == myObjectL){
                        myObjectL = new MyObjectL();
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return myObjectL;
    }
}

class GetMyObjectL extends Thread{
    @Override
    public void run() {
        System.out.println(MyObjectL.getInstance().hashCode());
    }
}
