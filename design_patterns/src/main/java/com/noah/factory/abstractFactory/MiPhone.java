package com.noah.factory.abstractFactory;

/**
 * @ClassName MiPhone
 * @Description TODO
 * @Author noah
 * @Date 5/31/21 5:03 PM
 * @Version 1.0
 **/
public class MiPhone implements PhoneInterface{
    @Override
    public void start() {
        System.out.println("小米开机");
    }

    @Override
    public void call() {
        System.out.println("小米打电话");
    }
}
