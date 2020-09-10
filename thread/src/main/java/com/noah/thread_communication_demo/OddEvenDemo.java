package com.noah.thread_communication_demo;

/**
 * @ClassName OddEvenDemo
 * @Description TODO
 * @Author noah
 * @Date 2020-05-28 17:01
 * @Version 1.0
 **/
public class OddEvenDemo {

    private int a = 0;
    private Object o = new Object();
    /**
     *
     * @Author yz
     * @Description 由奇数线程调用
     * @Date 2020-05-28 17:02
     * @param
     * @return void
     */
    public void odd(){
        while (a < 10){
            synchronized (o){
                if (a%2 == 1){
                    System.out.println(Thread.currentThread().getName() + "奇数: " + a);
                    a++;
                    o.notify();//唤醒偶数线程打印
                }else{
                    try {
                        o.wait();//等待偶数线程完毕
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }

    /**
     *
     * @Author yz
     * @Description 由偶数线程调用
     * @Date 2020-05-28 17:02
     * @param
     * @return void
     */
    public void even(){
        while (a < 10) {
            synchronized (o) {
                if (a % 2 == 0) {
                    System.out.println(Thread.currentThread().getName() + "偶数: " + a);
                    a++;
                    o.notify();//唤醒偶数线程打印
                } else {
                    try {
                        o.wait();//等待偶数线程完毕
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        OddEvenDemo oddEvenDemo = new OddEvenDemo();
        //1.开启奇数线程打印
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                oddEvenDemo.odd();
            }
        },"奇数线程");
        //2.开启偶数线程打印
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                oddEvenDemo.even();
            }
        },"偶数线程");

        thread1.start();
        thread2.start();
    }
}
