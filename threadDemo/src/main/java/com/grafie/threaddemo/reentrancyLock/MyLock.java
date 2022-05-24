package com.grafie.threaddemo.reentrancyLock;

/**
 * 模拟实现一个lock
 *
 * @author grafie grafie.cn
 * @version 1.0.0
 * @since 2022-05-20
 */
public class MyLock {

    private boolean isLocked;

    public synchronized void lock() throws InterruptedException {
        if (isLocked) {
            wait();
        }
        isLocked = true;
    }

    public synchronized void unlock() {
        isLocked = false;
        notify();
    }
}
