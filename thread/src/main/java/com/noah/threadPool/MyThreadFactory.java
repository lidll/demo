package com.noah.threadPool;

import com.oracle.tools.packager.Log;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName MyThreadFactory
 * @Description 自定义线程工厂,用于给ThreadPoolExecutor使用
 * @Author noah
 * @Date 5/26/21 10:28 PM
 * @Version 1.0
 **/
@Slf4j
public class MyThreadFactory implements ThreadFactory {

    private AtomicInteger threadNum = new AtomicInteger(0);
    private final String namePreifx = "threadPool-currentThreadNum-";

    @Override
    public Thread newThread(Runnable r) {
        String ThreadName = namePreifx + threadNum.getAndIncrement();
        CustomThreadGroup customThreadGroup = new CustomThreadGroup("custom_group");
        //非守护线程
        customThreadGroup.setDaemon(false);
        //优先级最大
        customThreadGroup.setMaxPriority(Thread.MAX_PRIORITY);
        return new Thread(customThreadGroup,r,ThreadName);
    }
}
class CustomThreadGroup extends ThreadGroup{

    public CustomThreadGroup(String name) {
        super(name);
    }
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        Log.debug("thread : " + t.getName() + e.getMessage());
    }
}