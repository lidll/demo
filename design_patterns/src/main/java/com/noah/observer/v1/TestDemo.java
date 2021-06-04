package com.noah.observer.v1;

import java.util.ArrayList;

/**
 * @ClassName TestDemo
 * @Description 观察者模式
 * @Author noah
 * @Date 6/1/21 9:30 AM
 * @Version 1.0
 **/
public class TestDemo {

    public static void main(String[] args) {
        baby baby = new baby();
        baby.wakeUp();
    }
}


interface observer{
    void wakeUp();
}

class baby implements observer{
    boolean cry = false;
    ArrayList<observer> observers = new ArrayList<>();

    {
        observers.add(new Dad());
        observers.add(new Mam());
    }

    @Override
    public void wakeUp() {
        System.out.println("宝宝醒了,开始哭了");
        cry = true;
        for (observer observer : observers) {
            observer.wakeUp();
        }

    }

    public boolean isCry(){
        return cry;
    }

}

class Dad implements observer{

    public void bababao(){
        System.out.println("爸爸抱");
    }

    @Override
    public void wakeUp() {
        this.bababao();
    }
}

class Mam implements observer{

    public void mamawei(){
        System.out.println("妈妈喂");
    }

    @Override
    public void wakeUp() {
        this.mamawei();
    }
}