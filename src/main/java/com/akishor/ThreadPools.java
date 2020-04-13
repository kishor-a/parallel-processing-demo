package com.akishor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPools {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10);
        //ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        //ExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(10);// more params

        Thread task = new Thread(() -> {
            System.out.println("This runnable, task started");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Task competed");
        });
        fixedThreadPool.submit(task);

        fixedThreadPool.shutdown(); //Completes all tasks running and in queue
        //fixedThreadPool.shutdownNow(); //Don't start pending tasks in queue. completes running ones with interrupt.
        //fixedThreadPool.awaitTermination(4, TimeUnit.SECONDS);
    }

}
