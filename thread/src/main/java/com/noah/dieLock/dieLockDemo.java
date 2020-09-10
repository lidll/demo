package com.noah.dieLock;

import java.net.HttpCookie;

/**
 * @ClassName dieLockDemo
 * @Description TODO
 * @Author noah
 * @Date 2020-05-27 16:32
 * @Version 1.0
 **/
public class dieLockDemo {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new deadLockRunnable(1),"线程1");
        Thread thread2 = new Thread(new deadLockRunnable(2),"线程2");
        thread1.start();
        thread2.start();

    }
}
