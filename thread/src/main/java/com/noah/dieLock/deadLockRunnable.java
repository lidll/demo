package com.noah.dieLock;

/**
 * @ClassName deadLockRunnable
 * @Description TODO
 * @Author noah
 * @Date 2020-05-27 16:25
 * @Version 1.0
 **/
public class deadLockRunnable implements Runnable{

    private int flag;
    private static Object o1 = new Object();
    private static Object o2 = new Object();


    public deadLockRunnable(int flag){
        this.flag = flag;
    }

    @Override
    public void run (){
        if (flag == 1){
            //线程1执行代码
            synchronized (o1){
                System.out.println(Thread.currentThread().getName() + "已获取到资源o1,请求o2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o2){
                    System.out.println(Thread.currentThread().getName() + "已经获取到o1和o2");
                }
            }
        }else{
            //线程2执行代码
            synchronized (o2){
                System.out.println(Thread.currentThread().getName() + "已获取到资源o2,请求o1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o1){
                    System.out.println(Thread.currentThread().getName() + "已经获取到o1和o2");
                }
            }
        }
    }
}
