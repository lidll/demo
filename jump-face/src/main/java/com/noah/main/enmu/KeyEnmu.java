package com.noah.main.enmu;

import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName KeyEnmu
 * @Description TODO
 * @Author noah
 * @Date 2020-06-08 17:33
 * @Version 1.0
 **/
public enum  KeyEnmu {
    LEFT(KeyEvent.VK_LEFT),
    RIGHT(KeyEvent.VK_RIGHT),
    UP(KeyEvent.VK_UP),
    DOWN(KeyEvent.VK_DOWN);

    KeyEnmu(int keyValue){
        this.keyValue = keyValue;
    }


    //键值
    private int keyValue;

    //按键
    private final static Set<Integer> keySet = new HashSet<>();

    public boolean use(){
        return keySet.contains(keyValue);
    }
    public static void add(int keyCode){
        keySet.add(keyCode);
    }
    public static void remove(int keyCode){
        keySet.remove(keyCode);
    }
}
