package com.guyw.study.concurrence;

import junit.framework.TestCase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class volatileTest extends TestCase {
    boolean stop = false;
    ExecutorService service = Executors.newFixedThreadPool(2);
 volatile boolean sstop =false;
    public void testVolatile() throws Exception{
        //线程1

        service.execute(()->{
            while(!stop){
            }
            System.out.println(1);

        });
        service.execute(()->{
            while(!sstop){
            }
            System.out.println(2);

        });
        Thread.sleep(2000);

        stop = true;
        sstop = true;
        System.out.println(222);


    }
}
