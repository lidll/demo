package com.noah.kuangshen;

/**
 * @ClassName TestJoin
 * @Description TODO
 * @Author noah
 * @Date 4/13/21 11:32 AM
 * @Version 1.0
 **/
public class TestJoin implements Runnable{


    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("线程join" + i);
        }
    }

    public static void main(String[] args) {
        TestJoin testJoin = new TestJoin();
        Thread thread = new Thread(testJoin);
        thread.start();
        for (int i = 0; i < 500; i++) {
            System.out.println("main" + i);
            if (i == 200) {
                try {
                    thread.join();//相当于线程插队,主线程阻塞,等待testJoin执行完成
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
