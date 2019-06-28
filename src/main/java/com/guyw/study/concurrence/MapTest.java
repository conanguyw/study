package com.guyw.study.concurrence;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

public class MapTest extends TestCase {
    ExecutorService service = Executors.newFixedThreadPool(50);

    public void testMap() throws InterruptedException {
        Map<Integer,String> hashMap = new HashMap<>();
        Map<Integer,String> concurrentHashMap = new ConcurrentHashMap<>();
        for (int i = 0; i < 10000; i++) {
            int finalI = i;
            service.execute(() -> {
                hashMap.put(finalI,"345");
                concurrentHashMap.put(finalI,"345");
                    }

            );
        }

        TimeUnit.SECONDS.sleep(1);
        System.out.println(concurrentHashMap.size());
        System.out.println(hashMap.size());

    }
}
