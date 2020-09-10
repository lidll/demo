package com.noah.thread_communication_demo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName ConditionDemo
 * @Description TODO
 * @Author noah
 * @Date 2020-05-28 17:22
 * @Version 1.0
 **/
public class ConditionDemo {

    private int a = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    /**
     * @param
     * @return void
     * @Author yz
     * @Description 由奇数线程调用
     * @Date 2020-05-28 17:02
     */
    public void odd() {
        while (a < 10) {
            lock.lock();
            try {
                if (a % 2 == 1) {
                    System.out.println(Thread.currentThread().getName() + "奇数: " + a);
                    a++;
                    condition.signal();//唤醒偶数线程打印
                } else {
                    try {
                        condition.await();//等待偶数线程打印完毕
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } finally {
                lock.unlock();
            }

        }

    }

    /**
     * @param
     * @return void
     * @Author yz
     * @Description 由偶数线程调用
     * @Date 2020-05-28 17:02
     */
    public void even() {
        while (a < 10) {
            lock.lock();
            try {
                if (a % 2 == 0) {
                    System.out.println(Thread.currentThread().getName() + "偶数: " + a);
                    a++;
                    condition.signal();//唤醒偶数线程打印
                } else {
                    try {
                        condition.await();//等待偶数线程完毕
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } finally {
                lock.unlock();
            }
        }

    }
    public static void main(String[] args) {
        ConditionDemo ConditionDemo = new ConditionDemo();
        //1.开启奇数线程打印
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                ConditionDemo.odd();
            }
        },"奇数线程");
        //2.开启偶数线程打印
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                ConditionDemo.even();
            }
        },"偶数线程");

        thread1.start();
        thread2.start();
    }
}
