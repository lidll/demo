package com.noah.threadSafe;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName Thread2
 * @Description TODO
 * @Author noah
 * @Date 2020-05-26 11:43
 * @Version 1.0
 **/
public class Thread2 implements Runnable{

    //cas保证参数原子性
    public static AtomicInteger count = new AtomicInteger(20);

    @Override
    public void run() {
        while (count.get() != 0){
            System.out.println(Thread.currentThread().getName() + "-------" + count.decrementAndGet());
        }
    }

}
