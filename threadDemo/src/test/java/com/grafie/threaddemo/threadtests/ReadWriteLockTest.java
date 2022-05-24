package com.grafie.threaddemo.threadtests;

import com.grafie.threaddemo.readwritelock.ReadWriteLockCacheService;
import org.junit.jupiter.api.Test;

/**
 * @author grafie grafie.cn
 * @version 1.0.0
 * @since 2022-05-20
 */
public class ReadWriteLockTest {
    @Test
    void putTest(){
        ReadWriteLockCacheService cacheService = new ReadWriteLockCacheService();

      Thread thread1 =  new Thread(new Runnable() {
            @Override
            public void run() {
                cacheService.put("1","string1");
            }
        });

        Thread thread2 =  new Thread(new Runnable() {
            @Override
            public void run() {
                cacheService.put("2","string2");
            }
        });

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                cacheService.put("3","string3");
            }
        });
        thread1.start();
        thread2.start();
        thread3.start();
        while (thread1.isAlive() || thread2.isAlive() || thread3.isAlive()){

        }
    }
    @Test
    void getTest(){
        ReadWriteLockCacheService cacheService = new ReadWriteLockCacheService();

      Thread thread1 =  new Thread(new Runnable() {
            @Override
            public void run() {
                cacheService.getValue("1");
            }
        });

        Thread thread2 =  new Thread(new Runnable() {
            @Override
            public void run() {
                cacheService.getValue("2");
            }
        });

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                cacheService.getValue("3");
            }
        });
        thread1.start();
        thread2.start();
        thread3.start();
        while (thread1.isAlive() || thread2.isAlive() || thread3.isAlive()){

        }
    }
    @Test
    void getSizeTest(){
        ReadWriteLockCacheService cacheService = new ReadWriteLockCacheService();

      Thread thread1 =  new Thread(new Runnable() {
            @Override
            public void run() {
                cacheService.getValue("1");
            }
        });

        Thread thread2 =  new Thread(new Runnable() {
            @Override
            public void run() {
                cacheService.getValue("2");
            }
        });

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                cacheService.getValue("3");
            }
        });
        Thread thread4 = new Thread(new Runnable() {
            @Override
            public void run() {
                cacheService.getSize();
            }
        });
        thread4.start();
        thread1.start();
        thread2.start();
        thread3.start();
        while (thread1.isAlive() || thread2.isAlive() || thread3.isAlive()){

        }
    }
}
