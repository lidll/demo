package com.tinto.noah.enumDemo;

/**
 * @ClassName Phone
 * @Description TODO
 * @Author noah
 * @Date 1/28/21 5:39 PM
 * @Version 1.0
 **/
public class Phone {
    private PhoneBrand brand;
    public enum PhoneBrand{
        HUAWEI,
        ONE_PLUS,
        OPPO,
        APPLE;
    }
    public boolean isBest(){
        return brand == PhoneBrand.APPLE;
    }

}
