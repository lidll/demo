package com.noah.kuangshen;


/**
 * @ClassName TestState
 * @Description TODO
 * @Author noah
 * @Date 4/13/21 11:47 AM
 * @Version 1.0
 **/
public class TestState{

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread over");
        });
        //new
        System.out.println(thread.getState());

        thread.start();
        System.out.println(thread.getState());

        while (thread.getState() != Thread.State.TERMINATED){
            System.out.println(thread.getState());
        }
        System.out.println(thread.getState());

    }
}
