package com.noah.factory.abstractFactory;

/**
 * @ClassName MiProductFactory
 * @Description TODO
 * @Author noah
 * @Date 5/31/21 5:09 PM
 * @Version 1.0
 **/
public class IProductFactory implements ProductFactory{
    @Override
    public PhoneInterface getPhone() {
        return new Iphone();
    }

    @Override
    public RouterInterface getRouter() {
        return new IRouter();
    }
}
