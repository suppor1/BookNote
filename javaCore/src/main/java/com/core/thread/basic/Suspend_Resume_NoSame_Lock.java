package com.core.thread.basic;

/**
 * Created by jiangkai
 * Date 2018/5/27
 */
public class Suspend_Resume_NoSame_Lock {
    public static void main(String[] args) throws Exception{
        final SynchrnoizedObject object = new SynchrnoizedObject();
        final Thread thread = new Thread(){
            @Override
            public void run() {
                object.setValue("a","aa");
            }
        };
        thread.setName("a");
        thread.start();
        Thread.sleep(1000);
        Thread thread1 = new Thread(){
            @Override
            public void run() {
                object.printUP();
                thread.resume();
                object.setValue("b","bb");
                object.printUP();

            }
        };

        thread1.start();
        System.out.println(Thread.currentThread().getName()+" end");

    }
}

class SynchrnoizedObject{//共享资源
    private String userName = "1";
    private String passWord = "11";

    synchronized public void setValue(String u, String p){
        this.userName = u;
        if(Thread.currentThread().getName().equals("a")){
            Thread.currentThread().suspend();
        }
        this.passWord = p;
    }

    public void printUP(){
        System.out.println("U:"+this.userName+" P:"+this.passWord);
    }
}
