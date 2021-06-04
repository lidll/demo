package com.noah.singleton;

/**
 * @ClassName Demo3
 * @Description 静态内部类
 * @Author noah
 * @Date 5/29/21 11:29 PM
 * @Version 1.0
 **/
public class Demo3 {

    private Demo3(){}

    private static class Demo3Holder {
        private final static Demo3 demo3 = new Demo3();
    }

    public static Demo3 getInstance(){
        return Demo3Holder.demo3;
    }

    //demo3在被加载的时候,里面的静态内部类是不会被加载的,只有在调用getInstance,其中的内部类才会被加载的
    //所以是属于lazy loading.jvm的方式控制单例.这种方式较为完美
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                System.out.println(Demo3.getInstance().hashCode());
            }).start();
        }
    }
}
