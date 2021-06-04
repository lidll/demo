package com.noah;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName testMain
 * @Description TODO
 * @Author noah
 * @Date 5/27/21 5:14 PM
 * @Version 1.0
 **/
public class testMain {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        Object a = context.getBean("user");
        System.out.println(a);
    }
}
