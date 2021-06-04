package com.noah.observer.v2;

import javax.rmi.CORBA.Tie;

/**
 * @ClassName TestMain
 * @Description TODO
 * @Author noah
 * @Date 6/1/21 10:56 AM
 * @Version 1.0
 **/
public class TestMain {

}
class Baby{
    public boolean cry = false;

    public void wekeUp(){
        cry = true;

        System.out.println("宝宝醒了");

        new WakeUpEvent(System.currentTimeMillis(),"bad",this);
    }
}

//事件
class WakeUpEvent{
    long timestamp;
    String loc;
    Baby source;

    public WakeUpEvent(long timestamp, String loc, Baby source){
        this.timestamp = timestamp;
        this.loc = loc;
        this.source = source;
    }
}


interface observer{
    void wakeUp(WakeUpEvent wakeUpEvent);
}

class Mam implements observer{

    @Override
    public void wakeUp(WakeUpEvent wakeUpEvent) {

    }
}

class Ded implements observer{

    @Override
    public void wakeUp(WakeUpEvent wakeUpEvent) {

    }
}
