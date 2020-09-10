package com.noah.main.enmu;

/**
 * @ClassName DirectionEnmu
 * @Description TODO
 * @Author noah
 * @Date 2020-06-08 17:02
 * @Version 1.0
 **/
public enum  DirectionEnmu {

    LEFT{
        @Override
        public boolean left(){return true;}
    },
    RIGHT{
        @Override
        public boolean right() {
            return true;
        }
    },
    UP,
    DOWN;

    public boolean left(){
        return false;
    }
    public boolean right(){
        return false;
    }

}
