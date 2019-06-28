package com.guyw.study.concurrence;

import junit.framework.TestCase;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExchangerTest extends TestCase {

    private static volatile boolean isDone = false;

    static class ExchangerProducer implements Runnable {
        private Exchanger<Integer> exchanger;
        private static int data = 1;
        ExchangerProducer(Exchanger<Integer> exchanger) {
            this.exchanger = exchanger;
        }

        @Override
        public void run() {
            while (!Thread.interrupted() && !isDone) {
                for (int i = 1; i <= 3; i++) {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                        data = i;
                        System.out.println("producer before: " + data);
                        data = exchanger.exchange(data);
                        System.out.println("producer after: " + data);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                isDone = true;
            }
        }
    }

    static class ExchangerConsumer implements Runnable {
        private Exchanger<Integer> exchanger;
        private static int data = 0;
        ExchangerConsumer(Exchanger<Integer> exchanger) {
            this.exchanger = exchanger;
        }

        @Override
        public void run() {
            while (!Thread.interrupted() && !isDone) {
                data = 0;
                try {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("consumer before : " + data);
                    data = exchanger.exchange(data);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("consumer after : " + data);
            }
        }
    }

    static class ExchangerConsumer2 implements Runnable {
        private Exchanger<Integer> exchanger;
        private static int data = 0;
        ExchangerConsumer2(Exchanger<Integer> exchanger) {
            this.exchanger = exchanger;
        }

        @Override
        public void run() {
            while (!Thread.interrupted() && !isDone) {
                data = 5;

                try {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("consumer2 before : " + data);
                    data = exchanger.exchange(data);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("consumer2 after : " + data);
            }
        }
    }



    public  void testExchanger() {
        //两两交互，第三个等待另外一个完成后到来再交互
        ExecutorService exec = Executors.newCachedThreadPool();
        Exchanger<Integer> exchanger = new Exchanger<Integer>();
        ExchangerProducer producer = new ExchangerProducer(exchanger);
        ExchangerConsumer consumer = new ExchangerConsumer(exchanger);
        ExchangerConsumer2 consumer2 = new ExchangerConsumer2(exchanger);

        exec.execute(producer);
        exec.execute(consumer);
        exec.execute(consumer2);
        exec.shutdown();
        try {
            exec.awaitTermination(30, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
