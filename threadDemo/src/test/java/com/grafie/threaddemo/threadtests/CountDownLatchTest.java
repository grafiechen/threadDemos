package com.grafie.threaddemo.threadtests;

import com.grafie.threaddemo.countdownlatch.CountDownLatchWorker;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author grafie grafie.cn
 * @version 1.0.0
 * @since 2022-05-20
 */
public class CountDownLatchTest {
    @Test
    void test() throws InterruptedException {
        int count = 10;
        AtomicInteger num = new AtomicInteger(0);
        CountDownLatch startLatch = new CountDownLatch(1);
        CountDownLatch endLatch = new CountDownLatch(count);
        for (int i = 0; i < count; i++) {
            new Thread(new CountDownLatchWorker(startLatch, endLatch, num)).start();
        }
        System.out.println("all start work");
        startLatch.countDown();
        System.out.println("wait for finish");
        endLatch.await();
        System.out.println("all finished");
        System.out.println(num.intValue() + " workers finished");
    }
}
