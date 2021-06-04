package com.noah.singleton;

/**
 * @ClassName Demo4
 * @Description 枚举单例,不仅可以解决线程同步,还可以防止反序列化
 * @Author noah
 * @Date 5/29/21 11:47 PM
 * @Version 1.0
 **/

public enum Demo4 {

    //防止序列化的作用,是可以防止反射的方式获取对象的实例,枚举单例不会被反序列化的原因是枚举类型没有构造方法
    INSTANCE;

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                System.out.println(Demo4.INSTANCE.hashCode());
            }).start();
        }
    }
}
