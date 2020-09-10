package com.noah.thread_communication_demo;

import java.net.HttpCookie;
import java.util.concurrent.CountDownLatch;

/**
 * @ClassName CountDownDemo
 * @Description TODO
 * @Author noah
 * @Date 2020-05-29 14:59
 * @Version 1.0
 **/
public class CountDownDemo {

    private CountDownLatch countDownLatch = new CountDownLatch(3);//设置要等待的运动员是3个




    /**
     *
     * @Author yz
     * @Description 运动员方法,由运动员线程调用
     * @Date 2020-05-29 15:01
     * @param
     * @return void
     */
    public void racer(){
        System.out.println(Thread.currentThread().getName() + "正在准备...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "准备完毕!");
        countDownLatch.countDown();
    }

    /**
     *
     * @Author yz
     * @Description 教练方法,由教练线程调用
     * @Date 2020-05-29 15:01
     * @param
     * @return void
     */
    public void coach(){
        //获取线程名称
        String name = Thread.currentThread().getName();
        System.out.println(name + "等待运动员准备...");
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("所有运动员已就位---" + name+"开始训练!");
    }

    public static void main(String[] args) {
        final CountDownDemo countDownDemo = new CountDownDemo();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                countDownDemo.racer();
            }
        },"运动员1");
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                countDownDemo.racer();
            }
        },"运动员2");
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                countDownDemo.racer();
            }
        },"运动员3");
        Thread thread4 = new Thread(new Runnable() {
            @Override
            public void run() {
                countDownDemo.coach();
            }
        },"教练");
        thread4.start();
        thread1.start();
        thread2.start();
        thread3.start();
    }


}
