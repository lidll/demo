package com.noah.kuangshen;

import java.util.HashSet;

/**
 * @ClassName Race
 * @Description TODO
 * @Author noah
 * @Date 4/12/21 3:35 PM
 * @Version 1.0
 **/
public class Race implements Runnable{

    private static String winner;
    private static boolean over = false;

    @Override
    public void run() {

        String name = Thread.currentThread().getName();

        for (int i = 1; i <= 100 ; i++) {
            if (this.isOver(i)) {
                break;
            }
            System.out.println(name + "跑了" + i + "步");
        }
    }

    public boolean isOver(int step){
        if (step == 100) {
            System.out.println(Thread.currentThread().getName() + "获胜");
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Race race = new Race();
        new Thread(race,"兔子").start();
        new Thread(race,"乌龟").start();
    }
}


