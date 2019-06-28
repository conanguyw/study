package com.guyw.study.concurrence;

import com.guyw.study.SelfException;
import junit.framework.TestCase;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author conangu
 * @createTime 2019-06-25 15:42
 * @description test
 */
public class CompletableFutureTest extends TestCase {

    public void testMethod1()  {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();
        new Thread(() -> {
            // 模拟执行耗时任务
            System.out.println("task doing...");

//                completableFuture.completeExceptionally(new SelfException("123","code"));
//
//            // 告诉completableFuture任务已经完成
//            completableFuture.complete("ok");
        }).start();
        // 获取任务结果，如果没有完成会一直阻塞等待
        String result = null;
        try {
            result = completableFuture.get();
        } catch (Exception e) {
            System.out.println(e.getCause() instanceof SelfException);
            System.out.println(SelfException.class.isInstance(e.getCause()) );
            System.out.println(e.getCause().getClass());
            System.out.println("计算结果:" + ((SelfException)e.getCause()).getCode());

            if (e.getCause() instanceof SelfException){
                System.out.println("计算结果:" + ((SelfException)e.getCause()).getCode());
            }
        }


        System.out.println("计算结果:" + result);
    }



}
