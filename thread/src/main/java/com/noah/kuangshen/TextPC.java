package com.noah.kuangshen;

/**
 * @ClassName TextPC
 * @Description TODO
 * @Author noah
 * @Date 4/13/21 4:36 PM
 * @Version 1.0
 **/
public class TextPC {

    public static void main(String[] args) {
        SyncContainer syncContainer = new SyncContainer();
        new Productor(syncContainer).start();
        new Consumer(syncContainer).start();
    }

}


//生产者
class Productor extends  Thread {

    SyncContainer container;

    public Productor(SyncContainer container){
        this.container = container;
    }
    @Override
    public void run(){
        for (int i = 1; i < 100; i++) {
            System.out.println("生产了" + i +"只鸡");
            Chicken chicken = new Chicken(i);
            container.push(chicken);
        }
    }
}

//消费者
class Consumer extends Thread {

    SyncContainer container;

    public Consumer(SyncContainer container){
        this.container = container;
    }

    @Override
    public void run(){
        Chicken pop = container.pop();
        System.out.println("吃了" + pop.id + "只鸡");
    }
}

//产品
class Chicken{
    int id;

    public Chicken(int id){
        this.id = id;
    }
}

//缓冲区
class SyncContainer{
   Chicken[] chickens = new Chicken[10];

   int count = 0;

   //生产者放入产品
    public  synchronized void push(Chicken chicken){
        //如果容器满了,就需要等待消费者消费
        if (count == chickens.length) {
            //通知消费者消费,生产等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //如果没有满,我们就需要丢入产品
        chickens[count] = chicken;
        count ++;

        //可以通知消费者了
        this.notifyAll();
    }

    //消费者消费产品
    public synchronized Chicken pop(){
        //判断能否消费
        if (count == 0) {
            //等待生产者生产
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //如果可以消费
        Chicken chicken = chickens[count];
        count--;

        //消费了.通知生产者生产
        this.notifyAll();
        return chicken;
    }
}