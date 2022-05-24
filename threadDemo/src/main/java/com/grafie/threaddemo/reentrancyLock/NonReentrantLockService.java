package com.grafie.threaddemo.reentrancyLock;

import java.util.HashMap;
import java.util.Map;

/**
 * @author grafie grafie.cn
 * @version 1.0.0
 * @since 2022-05-20
 */
public class NonReentrantLockService {
    private MyLock lock = new MyLock();
    private Map<String, String> map = new HashMap<>();

    public String get(String key) {
        try {
            lock.lock();
            return map.get(key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return null;
    }

    public String putAndGetOld(String key, String value) {
        try {
            System.out.println("start put,key==>" + key);
            lock.lock();
            System.out.println("get old value key==>" + key);
            String oldValue = get(key);
            System.out.println("put new value key==>" + key);
            map.put(key, value);
            return oldValue;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return null;
    }

    public void put(String key, String value) {
        try {
            lock.lock();
            System.out.println("put value key==>" + key);
            map.put(key, value);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
