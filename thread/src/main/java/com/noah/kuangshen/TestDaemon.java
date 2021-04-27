package com.noah.kuangshen;

import com.sun.org.apache.regexp.internal.RE;

/**
 * @ClassName TestDeamon
 * @Description 守护线程,上帝与人
 * @Author noah
 * @Date 4/13/21 2:41 PM
 * @Version 1.0
 **/
public class TestDaemon {

    public static void main(String[] args) {
        You you = new You();
        God god = new God();

        Thread thread = new Thread(god);
        //守护线程开启,false为用户线程
        thread.setDaemon(true);
        thread.start();

        new Thread(you).start();
        //虚拟机是不会等待守护线程执行完毕的
    }

}

class You implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 36000; i++) {
            System.out.println("快乐的生活了一天");
        }
        System.out.println("bye world");
    }
}

class God implements Runnable{
    @Override
    public void run() {
        while (true){
            System.out.println("上帝在守护着你");
        }
    }
}
