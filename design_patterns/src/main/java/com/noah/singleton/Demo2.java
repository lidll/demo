package com.noah.singleton;

/**
 * @ClassName Demo2
 * @Description 单例饿汉模式
 * @Author noah
 * @Date 5/29/21 11:24 PM
 * @Version 1.0
 **/
public class Demo2 {

    private static final Demo2 demo2 = new Demo2();

    public static Demo2 getInstance(){
        return demo2;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                System.out.println(Demo2.getInstance().hashCode());
            }).start();
        }
    }
}
