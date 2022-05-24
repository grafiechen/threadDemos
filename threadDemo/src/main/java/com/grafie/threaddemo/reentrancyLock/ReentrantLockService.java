package com.grafie.threaddemo.reentrancyLock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author grafie grafie.cn
 * @version 1.0.0
 * @since 2022-05-20
 */
public class ReentrantLockService {
    private ReentrantLock reentrantLock = new ReentrantLock();
    private Map<String, String> map = new HashMap<>();

    public String get(String key) {
        try {
            reentrantLock.lock();
            return map.get(key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
        return null;
    }

    public void put(String key, String value) {
        try {
            reentrantLock.lock();
            map.put(key, value);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    }

    public String putAndGetOld(String key, String value) {
        try {
            reentrantLock.lock();
            String oldValue = get(key);
            put(key, value);
            return oldValue;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
        return null;
    }
}
