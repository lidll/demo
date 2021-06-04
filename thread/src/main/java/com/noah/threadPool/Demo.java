package com.noah.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName Demo
 * @Description TODO
 * @Author noah
 * @Date 5/26/21 9:49 PM
 * @Version 1.0
 **/
public class Demo {

    public static void main(String[] args) {
        ThreadPoolExecutor threadPool = ThreadPoolDemo1.getThreadPool();

        try {
            for (int i = 0; i < 17; i++) {
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName());
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }
    }

}

//手动创建线程池
class ThreadPoolDemo1 {

    public static ThreadPoolExecutor getThreadPool(){
        /*
         7个核心参数
            corePoolSize核心线程数:用于执行线程
            maximumPoolSize最大线程数:
            keepAliveTime线程保留时间:
            timeUnit时间单位: 时间单位
            blockingQueue阻塞队列: ArrayBlockingQueue数组/LinkedBlockingQueue链表 两种实现,初始化都没有边界规定会引发oom
            threadFactory线程工厂: 用于创建线程
            rejectedExecutionHandler拒绝策略

         4种拒绝策略
            ThreadPoolExecutor.AbortPolicy ：丢弃任务，并抛出 RejectedExecutionException 异常。
            ThreadPoolExecutor.CallerRunsPolicy：该任务被线程池拒绝，由调用 execute方法的线程执行该任务。
            ThreadPoolExecutor.DiscardOldestPolicy ：抛弃队列最前面的任务，然后重新尝试执行任务。
            ThreadPoolExecutor.DiscardPolicy：丢弃任务，也不抛出异常。
        */

        //自定义线程工厂
        MyThreadFactory myThreadFactory = new MyThreadFactory();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                1,
                5,
                60L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(1),
                myThreadFactory,
                new ThreadPoolExecutor.AbortPolicy());
        return threadPoolExecutor;

        /*

        TimeUnit.DAYS; //日
        TimeUnit.HOURS; //小时
        TimeUnit.MINUTES; //分
        TimeUnit.SECONDS; //秒
        TimeUnit.MILLISECONDS; //毫秒
        TimeUnit.MICROSECONDS; //微妙
        TimeUnit.NANOSECONDS; //纳秒

         */
    }
}

//线程工具类的默认线程方案
class ThreadPoolDemo2{
    public ThreadPoolExecutor getThreadPool(){
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        ExecutorService executorService1 = Executors.newCachedThreadPool();
        ExecutorService executorService2 = Executors.newSingleThreadExecutor();
        ExecutorService executorService3 = Executors.newWorkStealingPool();
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
        ScheduledExecutorService scheduledExecutorService1 = Executors.newSingleThreadScheduledExecutor();
        return null;
    }
}

