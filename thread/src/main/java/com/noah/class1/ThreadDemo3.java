package com.noah.class1;

import org.openjdk.jol.info.ClassLayout;

/**
 * @ClassName ThreadDemo3
 * @Description TODO
 * @Author noah
 * @Date 2020-05-21 16:12
 * @Version 1.0
 **/
public class ThreadDemo3 {

//    Thread thread3 = new Thread(()->{
//
//
//    }).start();

    public static void main(String[] args) {
        Object o = new Object();
        int a = 1;
        System.out.println(ClassLayout.parseInstance(a).toPrintable());

    }

}
