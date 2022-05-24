package com.grafie.threaddemo.threadtests;

import com.grafie.threaddemo.reentrancyLock.NonReentrantLockService;
import com.grafie.threaddemo.reentrancyLock.ReentrantLockBySynchronizedService;
import com.grafie.threaddemo.reentrancyLock.ReentrantLockService;
import org.junit.jupiter.api.Test;

/**
 * @author grafie grafie.cn
 * @version 1.0.0
 * @since 2022-05-20
 */
public class ReentrantLockTest {

    @Test
    void nonReentrantLockTest() {
        NonReentrantLockService service = new NonReentrantLockService();
        service.put("1","a");
        System.out.println(service.get("1"));;
        service.putAndGetOld("1", "b");
    }

    @Test
    void synchronizedTest() {
        ReentrantLockBySynchronizedService service = new ReentrantLockBySynchronizedService();
        service.putAndGetOld("1", "a");
        service.get("1");
        service.putAndGetOld("1", "b");
    }
    @Test
    void reentrantLockTest(){
        ReentrantLockService service = new ReentrantLockService();
        service.put("1","a");
        System.out.println(service.get("1"));
        System.out.println(service.putAndGetOld("1","b"));
        System.out.println(service.get("1"));
    }

}
