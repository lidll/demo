package com.noah.main;

import com.noah.main.base.IDraw;

import javax.swing.*;
import java.awt.*;

/**
 * @ClassName GamePanel
 * @Description TODO
 * @Author noah
 * @Date 2020-06-08 17:23
 * @Version 1.0
 **/
public class GamePanel extends JPanel {
    //待绘制元素
    private IDraw[] iDraws;
    //缓冲
    private Image image;

    public GamePanel(IDraw...iDraws){
        this.iDraws = iDraws;
    }


    private void drawBufferedImage(){
        image = createImage(this.getWidth(), this.getHeight());
        Graphics graphics = image.getGraphics();
        //绘制
        for (IDraw iDraw : this.iDraws) {
            iDraw.drawImage(graphics);
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        drawBufferedImage();
        g.drawImage(this.image,0,0,this);
    }
}
