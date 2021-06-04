package com.noah.singleton;

/**
 * @ClassName Demo1
 * @Description 单例懒汉模式: 双重校验
 * @Author noah
 * @Date 5/29/21 11:09 PM
 * @Version 1.0
 **/
public class Demo1 {

    private static Demo1 demo1 = null;

    private static Demo1 getInstance(){
        if (demo1 == null) {
            synchronized (Demo1.class){
             if (demo1 == null) {
                 demo1 = new Demo1();
             }
           }
        }
        return demo1;
    }


    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                System.out.println(Demo1.getInstance().hashCode());
            }).start();
        }
    }
}
