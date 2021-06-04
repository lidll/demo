package com.noah.factory.abstractFactory;

/**
 * @ClassName MiRouter
 * @Description TODO
 * @Author noah
 * @Date 5/31/21 5:03 PM
 * @Version 1.0
 **/
public class MiRouter implements RouterInterface {
    @Override
    public void start() {
        System.out.println("小米路由器启动");
    }

    @Override
    public void contract() {
        System.out.println("小米路由器连接");
    }
}
