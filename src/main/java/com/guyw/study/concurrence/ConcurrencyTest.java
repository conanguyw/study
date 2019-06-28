package com.guyw.study.concurrence;

import junit.framework.TestCase;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

public class ConcurrencyTest extends TestCase {
    private ReentrantLock lock = new ReentrantLock();
    final CountDownLatch latch = new CountDownLatch(2);

    public void testMethod1(){
        TestVO testVO = new TestVO();

        System.out.println(testVO.getC());

        System.out.println("testMethod1 , hashCode = "+hashCode());
        Thread thread  = new MyThread();
        Thread thread2  = new MyThread();
        thread.start();
        thread2.start();
        thread2.interrupt();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    class MyThread extends Thread{
        @Override
        public void run() {
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + " running");
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName() + " finished");
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " interrupted");
            }finally {
                lock.unlock();
            }
        }
    }
}
