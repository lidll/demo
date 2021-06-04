package com.noah.factory.simpleFactory;

/**
 * @ClassName BirdFactory
 * @Description TODO
 * @Author noah
 * @Date 5/31/21 3:42 PM
 * @Version 1.0
 **/
public class BirdFactory {

    public static Bird getBrid(String color){
        switch (color){
            case "blue":
                return new BlueBird();
            case "red":
                return new RedBrid();
            default:
                return new BlackBrid();
        }
    }
}
