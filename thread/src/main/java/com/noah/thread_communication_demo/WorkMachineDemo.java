package com.noah.thread_communication_demo;


import java.util.concurrent.Semaphore;

/**
 * @ClassName WorkMachineDemo
 * @Description TODO
 * @Author noah
 * @Date 2020-06-03 14:53
 * @Version 1.0
 **/
public class WorkMachineDemo {

    static class Work implements Runnable{
        private int workerNums;//工人数
        private Semaphore semaphore;//机器数

        public Work(int workerNums, Semaphore semaphore){
            this.semaphore = semaphore;
            this.workerNums = workerNums;

        }

        @Override
        public void run() {
            try {
                //工人要去获取机器
                semaphore.acquire();
                //打印工人获取到机器,开始工作
                String name = Thread.currentThread().getName();
                System.out.println("获取到机器,开始工作...");
                //线程睡眠一秒,模拟工人使用机器工作过程
                Thread.sleep(1000);
                //使用完毕,释放机器,打印工人使用完毕,释放机器
                semaphore.release();
                System.out.println(name + "使用完毕,释放机器!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        int workers = 8;
        Semaphore semaphore = new Semaphore(3);
        Work work = new Work(workers, semaphore);
    }
}
