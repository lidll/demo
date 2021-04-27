package com.noah.kuangshen;

import com.noah.threadSafe.Ticket;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName TestLock
 * @Description TODO
 * @Author noah
 * @Date 4/13/21 4:02 PM
 * @Version 1.0
 **/
public class TestLock {
    public static void main(String[] args) {
        Ticket2 ticket = new Ticket2();
        new Thread(ticket).start();
        new Thread(ticket).start();
        new Thread(ticket).start();
    }

}
class Ticket2 implements Runnable{
    private Integer ticket = 10;

    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {

        while (true){
               lock.lock();
            try {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (ticket > 0) {
                    System.out.println(ticket--);
                }else{
                    break;
                }
            }finally {
               lock.unlock();
           }
        }
    }
}
