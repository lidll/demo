package com.noah.threadSafe;

/**
 * @ClassName TicketDemo
 * @Description TODO
 * @Author noah
 * @Date 2020-05-26 14:50
 * @Version 1.0
 **/
public class TicketDemo {

    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        Thread thread1 = new Thread(ticket,"窗口1");
        Thread thread2 = new Thread(ticket,"窗口2");
        Thread thread3 = new Thread(ticket,"窗口3");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
