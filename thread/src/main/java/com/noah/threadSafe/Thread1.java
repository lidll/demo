package com.noah.threadSafe;

/**
 * @ClassName Thread1
 * @Description TODO
 * @Author noah
 * @Date 2020-05-26 11:43
 * @Version 1.0
 **/
public class Thread1 implements Runnable{
    @Override
    public void run() {

        while (Thread2.count.get() != 0){
            System.out.println(Thread.currentThread().getName() + "-------" + Thread2.count.decrementAndGet());
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new Thread1());
        Thread thread1 = new Thread(new Thread2());
        thread.start();
        thread1.start();
    }
}
