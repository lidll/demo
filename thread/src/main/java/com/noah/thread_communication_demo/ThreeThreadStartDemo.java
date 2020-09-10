package com.noah.thread_communication_demo;

import java.util.Date;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @ClassName ThreeThreadStartDemo
 * @Description TODO
 * @Author noah
 * @Date 2020-06-01 15:02
 * @Version 1.0
 **/
public class ThreeThreadStartDemo {
    //参数是参与cyclicBarrier的线程数
    private CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
    public void startThree(){
        //1 打印线程准备启动
        System.out.println(Thread.currentThread().getName() + "正在准备...");
        //2 调用CyclicBarriar的await方法等待线程全部准备完毕
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        //3 答应线程启动完毕信息
        System.out.println(Thread.currentThread().getName() +"已经启动完毕:" + new Date().getTime());
    }

    public static void main(String[] args) {
        final ThreeThreadStartDemo threeThreadStartDemo = new ThreeThreadStartDemo();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                threeThreadStartDemo.startThree();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                threeThreadStartDemo.startThree();
            }
        });
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                threeThreadStartDemo.startThree();
            }
        });
        thread1.start();
        thread2.start();
        thread3.start();
    }

}
