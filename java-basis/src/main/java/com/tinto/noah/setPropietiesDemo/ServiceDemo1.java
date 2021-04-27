package com.tinto.noah.setPropietiesDemo;

/**
 * @ClassName ServiceDemo1
 * @Description TODO
 * @Author noah
 * @Date 2/3/21 5:19 PM
 * @Version 1.0
 **/
public class ServiceDemo1 {

    public static void main(String[] args) {
        ServiceDemo2 serviceDemo2 = new ServiceDemo2();
        DemoDO demoDO = new DemoDO();
        demoDO.setName("susan");
        demoDO.setAge(12);
        System.out.println(demoDO);
        serviceDemo2.setValue(demoDO);
        System.out.println(demoDO);

    }
}
