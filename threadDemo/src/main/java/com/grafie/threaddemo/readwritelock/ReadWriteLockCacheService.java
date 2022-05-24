package com.grafie.threaddemo.readwritelock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author grafie grafie.cn
 * @version 1.0.0
 * @since 2022-05-20
 */
public class ReadWriteLockCacheService {
    private final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private final static Map<String, String> CACHE_MAP = new HashMap<>();

    /**
     * 根据key 获取对应的value
     *
     * @param key map key
     * @return String
     */
    public String getValue(String key) {
        System.out.println("threadName:" + Thread.currentThread().getName() + "，开始时间:" + System.currentTimeMillis());
        try {
            readWriteLock.readLock().lock();
            System.out.println("开睡，threadName:"+Thread.currentThread().getName());
            sleep();
            return CACHE_MAP.get(key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
            System.out.println("threadName:" + Thread.currentThread().getName() + "，结束时间:" + System.currentTimeMillis());
        }
        return null;
    }

    /**
     * 添加
     *
     * @param key   map key
     * @param value map value
     */
    public void put(String key, String value) {
        System.out.println("threadName:" + Thread.currentThread().getName() + "，开始时间:" + System.currentTimeMillis());
        try {
            readWriteLock.writeLock().lock();
            Thread.sleep(500L);
            System.out.println("put value"+key);
            CACHE_MAP.put(key, value);
            System.out.println("threadName:" + Thread.currentThread().getName() + "，结束时间:" + System.currentTimeMillis());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    private void sleep() throws InterruptedException {
        Thread.sleep(5000L);
    }

    /**
     * 获取大小
     *
     * @return int - the map size
     */
    public int getSize() {
        System.out.println("查询size，threadName:" + Thread.currentThread().getName() + "，开始时间:" + System.currentTimeMillis());
        try {
            readWriteLock.writeLock().lock();
            Thread.sleep(5000L);
            return CACHE_MAP.size();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();
            System.out.println("查询size，threadName:" + Thread.currentThread().getName() + "，结束时间:" + System.currentTimeMillis());
        }
        return 0;
    }
}
