package com.noah.Decorator;

/**
 * @ClassName TestMain
 * @Description 装饰者模式
 * @Author noah
 * @Date 5/31/21 5:48 PM
 * @Version 1.0
 **/
public class TestMain {
    public static void main(String[] args) {
        //装饰者模式,增强类需要持有被装饰者的对象,并且与被装饰者实现同一个接口
        PersonDecorator personDecorator = new PersonDecorator(new Person());
        personDecorator.go();
    }
}
