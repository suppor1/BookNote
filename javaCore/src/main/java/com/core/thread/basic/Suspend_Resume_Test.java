package com.core.thread.basic;

/**
 * Created by jiangkai
 * Date 2018/5/27
 */
public class Suspend_Resume_Test extends Thread {

    private long i;

    public long getI() {
        return i;
    }

    public void setI(long i) {
        this.i = i;
    }

    @Override
    public void run() {
        super.run();
        while (true){
            i++;
        }

    }

    public static void main(String[] args) throws Exception{
        Suspend_Resume_Test suspend_resume_test = new Suspend_Resume_Test();
        suspend_resume_test.start();
        Thread.sleep(2000);
        suspend_resume_test.suspend();
        System.out.println("ThreadName"+suspend_resume_test.getName()+" i:"+suspend_resume_test.getI());
        Thread.sleep(2000);
        System.out.println("ThreadName"+suspend_resume_test.getName()+" i:"+suspend_resume_test.getI());
        suspend_resume_test.resume();
        Thread.sleep(1000);
        System.out.println("ThreadName"+suspend_resume_test.getName()+" i:"+suspend_resume_test.getI());

    }
}


