package com.noah.factory.simpleFactory;

/**
 * @ClassName TestMain
 * @Description 简单工厂模式
 * @Author noah
 * @Date 5/31/21 3:42 PM
 * @Version 1.0
 **/
public class TestMain {

    public static void main(String[] args) {
        //需要什么样的实现类,就通过标识去获取对应类
        Bird blueBrid = BirdFactory.getBrid("blue");
        blueBrid.birdCall();
        Bird redBird = BirdFactory.getBrid("red");
        redBird.birdCall();
        Bird brid = BirdFactory.getBrid("");
        brid.birdCall();
    }
}
