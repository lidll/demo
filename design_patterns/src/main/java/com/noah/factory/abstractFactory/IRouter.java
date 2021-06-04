package com.noah.factory.abstractFactory;

/**
 * @ClassName IRouter
 * @Description TODO
 * @Author noah
 * @Date 5/31/21 5:05 PM
 * @Version 1.0
 **/
public class IRouter implements RouterInterface{
    @Override
    public void start() {
        System.out.println("苹果路由器卡机");
    }

    @Override
    public void contract() {
        System.out.println("苹果路由器连接");
    }
}
