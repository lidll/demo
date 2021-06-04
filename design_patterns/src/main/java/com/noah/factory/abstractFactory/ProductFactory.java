package com.noah.factory.abstractFactory;

/**
 * @ClassName ProductFactory
 * @Description TODO
 * @Author noah
 * @Date 5/31/21 5:06 PM
 * @Version 1.0
 **/
public interface ProductFactory {

    PhoneInterface getPhone();

    RouterInterface getRouter();
}
