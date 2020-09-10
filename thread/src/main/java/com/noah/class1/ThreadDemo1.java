package com.noah.class1;

/**
 * @ClassName ThreadDemo1
 * @Description TODO
 * @Author noah
 * @Date 2020-05-21 16:04
 * @Version 1.0
 **/
public class ThreadDemo1 extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("thread1");
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new ThreadDemo1();
        Thread thread2 = new Thread(new ThreadDemo2());
        try {
            thread2.start();
            Thread.yield();
            thread1.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
