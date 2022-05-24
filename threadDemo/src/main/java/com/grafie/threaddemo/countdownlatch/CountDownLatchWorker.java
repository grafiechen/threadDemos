package com.grafie.threaddemo.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author grafie grafie.cn
 * @version 1.0.0
 * @since 2022-05-20
 */
public class CountDownLatchWorker implements Runnable {
    private final CountDownLatch startLatch;
    private final CountDownLatch endLatch;
    private final AtomicInteger num;

    public CountDownLatchWorker(CountDownLatch startLatch, CountDownLatch endLatch, AtomicInteger num) {
        this.startLatch = startLatch;
        this.endLatch = endLatch;
        this.num = num;
    }

    @Override
    public void run() {
        try {
            String threadName = Thread.currentThread().getName();
            System.out.println("wait for start:" + threadName);
            startLatch.await();
            System.out.println("work work" + threadName);
            num.getAndIncrement();
            System.out.println(threadName + ",finished");
            endLatch.countDown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
