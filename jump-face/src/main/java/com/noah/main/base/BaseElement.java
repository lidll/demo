package com.noah.main.base;

import com.noah.main.enmu.DirectionEnmu;

import java.awt.*;

/**
 * @ClassName BaseElement
 * @Description 基础类
 * @Author noah
 * @Date 2020-06-08 16:49
 * @Version 1.0
 **/
public abstract class BaseElement {
    //坐标
    protected int x,y;
    //大小
    protected int width,height;
    //图像
    protected  Image image;
    //移动速度
    protected int xSpeed,ySpeed;
    //方向
    protected DirectionEnmu directionEnmu;


    public BaseElement(int x,int y){
        this.x = x;
        this.y = y;
    }
    public BaseElement(){};

    /**
     *
     * @Author yz
     * @Description 绘制图片:用于显示
     * @Date 2020-06-08 16:54
     * @param g
     * @return void
     */
    void drawImage(Graphics g){
        g.drawImage(this.image,this.x,this.y,this.width,this.height,null);
    }
    /**
     *
     * @Author yz
     * @Description 动作:用于运动
     * @Date 2020-06-08 16:53
     * @param 
     * @return void
     */
    void action(){
        this.xMove();
        this.yMove();
    }

    protected void xMove(){
        this.x += directionEnmu.right() ? xSpeed:-xSpeed;
    }
    protected void yMove(){

    }
    /**
     *
     * @Author yz,用于判断相交
     * @Description 获取矩形
     * @Date 2020-06-08 16:53
     * @param 
     * @return void
     */
    Rectangle getRectangle(){
        return new Rectangle(this.x,this.y,this.width,this.height);
    }

    /**
     *
     * @Author yz
     * @Description 判断元素是否相交
     * @Date 2020-06-08 16:58
     * @param element
     * @return boolean
     */
    public <E extends BaseElement> boolean intersects(E element){
        return  this.getRectangle().intersects(element.getRectangle());
    }
    
}
