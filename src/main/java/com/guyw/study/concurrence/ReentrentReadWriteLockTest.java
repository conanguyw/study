package com.guyw.study.concurrence;

import junit.framework.TestCase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrentReadWriteLockTest extends TestCase {
    ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public static void main(String[] args) {
        final ReentrentReadWriteLockTest locks = new ReentrentReadWriteLockTest();
        // 建N个线程，同时读写
        ExecutorService service = Executors.newFixedThreadPool(6);
        service.execute(() -> locks.readFile(Thread.currentThread()));

        service.execute(() -> locks.readFile(Thread.currentThread()));

        service.execute(() -> locks.writeFile(Thread.currentThread()));

        service.execute(() -> locks.writeFile(Thread.currentThread()));
    }

    // 读操作
    public void readFile(Thread thread) {
        lock.readLock().lock();
        boolean readLock = lock.isWriteLocked();
        if (!readLock) {
            System.out.println("当前为读锁！");
        }
        try {
            TimeUnit.SECONDS.sleep(2);
            System.out.println(thread.getName() + ":读操作完毕！");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("释放读锁！");
            lock.readLock().unlock();
        }
    }

    // 写操作
    public void writeFile(Thread thread) {
        lock.writeLock().lock();
        boolean writeLock = lock.isWriteLocked();
        if (writeLock) {
            System.out.println("当前为写锁！");
        }
        try {
            TimeUnit.SECONDS.sleep(2);
            System.out.println(thread.getName() + ":写操作完毕！");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("释放写锁！");
            lock.writeLock().unlock();
        }

    }
}
