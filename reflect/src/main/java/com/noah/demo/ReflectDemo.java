package com.noah.demo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @ClassName ReflectDemo
 * @Description TODO
 * @Author noah
 * @Date 4/22/21 2:32 PM
 * @Version 1.0
 **/
public class ReflectDemo {

    //测试速度
    //正常调用方法
    //反射调用方法
    //关闭检测发射调用方法
    public static void test1(){
        User user = new User();
        long startDate = System.currentTimeMillis();

        for (int i = 0; i < 1000000000; i++) {
            user.getName();
        }
        long endDate = System.currentTimeMillis();

        System.out.println("普通调用时间:" + (endDate - startDate) + "ms");
    }

    public static void test2() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        User user = new User();
        Class userClass = Class.forName("com.noah.demo.User");
        Method getName = userClass.getDeclaredMethod("getName", null);
        long startDate = System.currentTimeMillis();

        for (int i = 0; i < 1000000000; i++) {
            getName.invoke(user,null);
        }
        long endDate = System.currentTimeMillis();

        System.out.println("反射调用时间:" + (endDate - startDate) + "ms");
    }
    public static void test3() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        User user = new User();
        Class userClass = Class.forName("com.noah.demo.User");
        Method getName = userClass.getDeclaredMethod("getName", null);
        long startDate = System.currentTimeMillis();
        getName.setAccessible(true);
        for (int i = 0; i < 1000000000; i++) {
            getName.invoke(user,null);
        }
        long endDate = System.currentTimeMillis();

        System.out.println("关闭检测反射调用时间:" + (endDate - startDate) + "ms");
    }

    public static void main(String[] args) {
        test1();
        try {
            test2();
            test3();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}

