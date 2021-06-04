package com.noah.factory.abstractFactory;

/**
 * @ClassName Iphone
 * @Description TODO
 * @Author noah
 * @Date 5/31/21 5:05 PM
 * @Version 1.0
 **/
public class Iphone implements PhoneInterface {
    @Override
    public void start() {
        System.out.println("iPhone开机");
    }

    @Override
    public void call() {
        System.out.println("iPhone打电话");
    }
}
