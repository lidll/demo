package com.noah.strategy;

/**
 * @ClassName TestMain
 * @Description 策略模式
 * @Author noah
 * @Date 5/31/21 3:35 PM
 * @Version 1.0
 **/
public class TestMain {

    public static void main(String[] args) {
        //策略对象实现同一个接口,策略方法各自实现具体内容,策略控制控制类持有策略实例,执行方法时,会执行具体策略方法
        //当有新的策略加入时,只需要实现策略接口,提供一个具体策略即可
        WeaponAttack ak47 = new WeaponAttack(new AK47());
        WeaponAttack m4a1 = new WeaponAttack(new M4A1());

        ak47.weaponShort();
        m4a1.weaponShort();

    }
}



