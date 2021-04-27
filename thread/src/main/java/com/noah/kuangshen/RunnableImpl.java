package com.noah.kuangshen;

/**
 * @ClassName RunnableImpl
 * @Description 多线程操作同一个对象
 * @Author noah
 * @Date 4/12/21 3:26 PM
 * @Version 1.0
 **/
public class RunnableImpl implements Runnable {

    private Integer tiketCount = 10;

    @Override
    public void run() {
        while (tiketCount != 0){
            System.out.println(Thread.currentThread().getName() + "卖出一张票,剩余" + tiketCount-- + "张票");
        }
    }

    public static void main(String[] args) {
        RunnableImpl runnable = new RunnableImpl();
        Thread t1 = new Thread(runnable,"爸爸");
        Thread t2 = new Thread(runnable,"妈妈");
        Thread t3 = new Thread(runnable,"儿子");
        t1.start();
        t2.start();
        t3.start();
//
//        儿子卖出一张票,剩余9张票
//        儿子卖出一张票,剩余8张票
//        妈妈卖出一张票,剩余10张票
//        妈妈卖出一张票,剩余6张票
//        妈妈卖出一张票,剩余5张票
//        妈妈卖出一张票,剩余4张票
//        爸爸卖出一张票,剩余10张票
//        妈妈卖出一张票,剩余3张票
//        儿子卖出一张票,剩余7张票
//        妈妈卖出一张票,剩余1张票
//        爸爸卖出一张票,剩余2张票
        
        //并发出现数据紊乱
    }
}
