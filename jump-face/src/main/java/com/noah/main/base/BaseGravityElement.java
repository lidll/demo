package com.noah.main.base;

/**
 * @ClassName BaseGravityElement
 * @Description TODO
 * @Author noah
 * @Date 2020-06-08 17:12
 * @Version 1.0
 **/
public abstract class BaseGravityElement extends BaseElement implements IGravity{

    //是否在地面
    protected boolean onTheGround;

    public BaseGravityElement(int x,int y){
        super(x,y);
    }

    @Override
    public Boolean onTheGround() {
        return onTheGround;
    }

    public void setOnTheGround(boolean onTheGround){
        this.onTheGround = onTheGround;
    }

    @Override
    public float getQuality() {
        //默认质量
        return 100;
    }

    @Override
    public int getY() {
        return 0;
    }

    @Override
    public void setY() {

    }
}
