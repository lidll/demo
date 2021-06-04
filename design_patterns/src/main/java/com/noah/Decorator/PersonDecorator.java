package com.noah.Decorator;

/**
 * @ClassName PersonDecorator
 * @Description TODO
 * @Author noah
 * @Date 5/31/21 5:42 PM
 * @Version 1.0
 **/
public class PersonDecorator implements GeneralInterface{

    private GeneralInterface generalInterface;

    @Override
    public void go() {
        System.out.println("增强方法啦");
        generalInterface.go();
    }

    public PersonDecorator (GeneralInterface generalInterface){
        this.generalInterface = generalInterface;
    }

}


