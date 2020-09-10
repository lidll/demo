package com.noah.threadSafe;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName Ticket
 * @Description TODO
 * @Author noah
 * @Date 2020-05-26 14:47
 * @Version 1.0
 **/
public class Ticket implements Runnable {
    private int tickets = 100;
    private Object o = new Object();

    //重入锁 true 参数是 是否公平锁: true公平锁;false非公平锁,独占锁
    private Lock lock = new ReentrantLock(true);
    @Override
    public void run() {
        while (true){
            lock.lock();
            try {
                if (tickets > 0){
                    System.out.println(Thread.currentThread().getName() + "销售票,剩余" + tickets--);
                }
            }finally {
                lock.unlock();
            }
        }
    }
}
