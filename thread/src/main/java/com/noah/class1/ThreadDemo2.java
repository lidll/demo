package com.noah.class1;

/**
 * @ClassName ThreadDemo2
 * @Description TODO
 * @Author noah
 * @Date 2020-05-21 16:09
 * @Version 1.0
 **/
public class ThreadDemo2 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("当前线程:" + Thread.currentThread().getName() + ",执行次数:" + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // 线程状态
    public static void main(String[] args) {
        Thread thread = new Thread(new ThreadDemo2());
        //new
        System.out.println(thread.getState());
        thread.start();
        //runnable
        System.out.println(thread.getState());
        try {
            Thread.sleep(1000);
            System.out.println(thread.getState());
            thread.join();
            System.out.println(thread.getState());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
