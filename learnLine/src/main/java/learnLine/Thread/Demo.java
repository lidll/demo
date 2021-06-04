package learnLine.Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/**
 * @ClassName Demo
 * @Description TODO
 * @Author noah
 * @Date 5/18/21 2:43 PM
 * @Version 1.0
 **/
public class Demo {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Thread thread = new Thread(()->{
            System.out.println(Thread.currentThread().getName());
        });

        for (int i = 0; i < 100; i++) {
            executorService.execute(thread);
        }
    }
}
