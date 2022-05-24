package com.grafie.threaddemo.reentrancyLock;

import java.util.HashMap;
import java.util.Map;

/**
 * @author grafie grafie.cn
 * @version 1.0.0
 * @since 2022-05-20
 */
public class ReentrantLockBySynchronizedService {
    private final Map<String, String> map = new HashMap<>();

    public synchronized String putAndGetOld(String key, String value) {
        String oldValue = get(key);
        map.put(key, value);
        return oldValue;
    }

    public synchronized String get(String key) {
        return map.get(key);
    }
}
