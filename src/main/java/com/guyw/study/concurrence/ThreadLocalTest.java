package com.guyw.study.concurrence;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalTest extends TestCase {
    ExecutorService          service     = Executors.newFixedThreadPool(50);
    static final ThreadLocal threadLocal = new ThreadLocal();

    public void testLocal() {

        for (int i = 0; i < 50; i++) {
            service.execute(() -> {
                threadLocal.set(Thread.currentThread());

                print();

            }

            );
        }

    }

    public void print() {
        System.out.println(threadLocal.get());
    }
}
