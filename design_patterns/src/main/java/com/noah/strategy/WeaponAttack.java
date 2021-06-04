package com.noah.strategy;

/**
 * @ClassName WeaponAttack
 * @Description TODO
 * @Author noah
 * @Date 5/31/21 3:33 PM
 * @Version 1.0
 **/
public class WeaponAttack {

    private Weapon weapon;

    public WeaponAttack(Weapon weapon){
        this.weapon = weapon;
    }

    public void weaponShort(){
        weapon.attack();
    }

}
