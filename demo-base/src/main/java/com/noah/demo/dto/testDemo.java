package com.noah.demo.dto;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @ClassName testDemo
 * @Description TODO
 * @Author noah
 * @Date 2020-10-22 15:25
 * @Version 1.0
 **/
public class testDemo {
    public static void main(String[] args) {
        HashSet<String> integers = new HashSet<>();
        integers.add("a");
        integers.add("b");
        integers.add("c");
        integers.remove("b");
        System.out.println(integers);
    }
}
