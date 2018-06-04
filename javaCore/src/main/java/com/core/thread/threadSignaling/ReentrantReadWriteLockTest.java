package com.core.thread.threadSignaling;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by jiangkai
 * Date 2018/6/4
 */
public class ReentrantReadWriteLockTest {
    public static void main(String[] args) {
        //读读锁共享验证
//        ReadReadLockShare readReadLockShare = new ReadReadLockShare();
//        readReadLockShare.run();
        //写写锁互斥
//        WriteWritemutualxclusionLock writeWritemutualxclusionLock = new WriteWritemutualxclusionLock();
//        writeWritemutualxclusionLock.run();
        //读写锁互斥
//        ReadWritemutualxclusionLock readWritemutualxclusionLock = new ReadWritemutualxclusionLock();
//        readWritemutualxclusionLock.run();
        //写读锁互斥
        WriteReadmutualxclusionLock writeReadmutualxclusionLock = new WriteReadmutualxclusionLock();
        writeReadmutualxclusionLock.run();

    }


}


class ReadReadLockShare{
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private void read(){
        try {
            lock.readLock().lock();
            System.out.println(Thread.currentThread().getName()+" 获得Read锁"+System.currentTimeMillis());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } finally {
            lock.readLock().unlock();
        }
    }
    public void run(){
        Thread threadA = new Thread(new Runnable() {
            public void run() {
                read();
            }
        });
        threadA.setName("A");
        threadA.start();
        Thread threadB = new Thread(new Runnable() {
            public void run() {
                read();
            }
        });
        threadB.setName("B");
        threadB.start();
    }
}

class WriteWritemutualxclusionLock{
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private void write(){
        try {
            lock.writeLock().lock();
            System.out.println(Thread.currentThread().getName()+" 获得Read锁"+System.currentTimeMillis());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } finally {
            lock.writeLock().unlock();
        }
    }
    public void run(){
        Thread threadA = new Thread(new Runnable() {
            public void run() {
                write();
            }
        });
        threadA.setName("A");
        threadA.start();
        Thread threadB = new Thread(new Runnable() {
            public void run() {
                write();
            }
        });
        threadB.setName("B");
        threadB.start();
    }
}


class ReadWritemutualxclusionLock{
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    private void read(){
        try {
            lock.readLock().lock();
            System.out.println(Thread.currentThread().getName()+" 获得Read锁"+System.currentTimeMillis());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } finally {
            lock.readLock().unlock();
        }
    }

    private void write(){
        try {
            lock.writeLock().lock();
            System.out.println(Thread.currentThread().getName()+" 获得Read锁"+System.currentTimeMillis());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } finally {
            lock.writeLock().unlock();
        }
    }
    public void run(){
        Thread threadA = new Thread(new Runnable() {
            public void run() {
                read();
            }
        });
        threadA.setName("A");
        threadA.start();
        Thread threadB = new Thread(new Runnable() {
            public void run() {
                write();
            }
        });
        threadB.setName("B");
        threadB.start();
    }
}


class WriteReadmutualxclusionLock{
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    private void read(){
        try {
            lock.readLock().lock();
            System.out.println(Thread.currentThread().getName()+" 获得Read锁"+System.currentTimeMillis());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } finally {
            lock.readLock().unlock();
        }
    }

    private void write(){
        try {
            lock.writeLock().lock();
            System.out.println(Thread.currentThread().getName()+" 获得Read锁"+System.currentTimeMillis());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } finally {
            lock.writeLock().unlock();
        }
    }
    public void run(){
        Thread threadA = new Thread(new Runnable() {
            public void run() {
                write();
            }
        });
        threadA.setName("A");
        threadA.start();
        Thread threadB = new Thread(new Runnable() {
            public void run() {
                read();
            }
        });
        threadB.setName("B");
        threadB.start();
    }
}