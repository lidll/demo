package com.noah.class1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName ExecutorsDemo
 * @Description TODO
 * @Author noah
 * @Date 2020-05-26 09:44
 * @Version 1.0
 **/
public class ExecutorsDemo {



    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.execute(new ThreadDemo2());

        Thread thread = new Thread(new ThreadDemo2());
        thread.start();
    }


}
