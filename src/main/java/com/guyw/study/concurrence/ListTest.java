package com.guyw.study.concurrence;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ListTest extends TestCase {
    ExecutorService service = Executors.newFixedThreadPool(100);

    public void testList() throws Exception{
        List<String> arryList = new ArrayList();
        List<String> copyOnWriteArrayList = new CopyOnWriteArrayList();
        for (int i = 0; i < 10000; i++) {
            service.execute(() -> {
                arryList.add("345");
                copyOnWriteArrayList.add("345");
            }

            );
        }
        TimeUnit.SECONDS.sleep(1);
        System.out.println(copyOnWriteArrayList.size());
        System.out.println(arryList.size());


    }

}
