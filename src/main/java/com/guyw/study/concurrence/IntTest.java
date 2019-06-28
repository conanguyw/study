package com.guyw.study.concurrence;

import junit.framework.TestCase;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class IntTest extends TestCase {

    ExecutorService service = Executors.newFixedThreadPool(50);
    int a = 0;
    AtomicInteger b = new AtomicInteger(0);

    public void testInt() throws InterruptedException {
        for (int i = 0; i < 10000; i++) {
            service.execute(() -> {
                a++;
                b.addAndGet(1);
            }

            );
        }
        TimeUnit.SECONDS.sleep(1);
        System.out.println(b.get());
        System.out.println(a);


    }
}
