package com.noah.main;

import com.noah.main.enmu.KeyEnmu;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.TimerTask;

/**
 * @ClassName GameFrame
 * @Description TODO
 * @Author noah
 * @Date 2020-06-08 17:59
 * @Version 1.0
 **/
public class GameFrame extends JFrame {
    public GameFrame(){
        this.setTitle("jump face");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(100,100);
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                KeyEnmu.add(e.getKeyCode());
            }

            @Override
            public void keyReleased(KeyEvent e) {
                KeyEnmu.remove(e.getKeyCode());
            }
        });

        java.util.Timer timer = new java.util.Timer();
        TimerTask timerTask = new TimerTask(){
            @Override
            public void run() {

            }
        };
        timer.schedule(timerTask,0,25);

    }
}
