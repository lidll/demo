package com.noah.factory.abstractFactory;

/**
 * @ClassName TestMain
 * @Description 抽象工厂模式
 * @Author noah
 * @Date 5/31/21 5:11 PM
 * @Version 1.0
 **/
public class TestMain {
    public static void main(String[] args) {
        //利用多态的特点,可以方便处理产品族的情况
        ProductFactory productFactory = new IProductFactory();
        productFactory.getPhone().start();
        productFactory.getRouter().start();

        productFactory = new MiProductFactory();
        productFactory.getPhone().start();
        productFactory.getRouter().start();
    }
}
