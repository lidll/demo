package com.noah.class1;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @ClassName Do
 * @Description TODO
 * @Author noah
 * @Date 2020-05-22 17:14
 * @Version 1.0
 **/
public class Do {

    private int count = 1;

   public void method(){

       AtomicInteger atomicInteger = new AtomicInteger();

       synchronized (this){
           count ++ ;
           System.out.println(Thread.currentThread().getName() +"count = " + count);
       }
   }
}
