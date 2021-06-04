package learnLine.extend;

/**
 * @ClassName Man
 * @Description TODO
 * @Author noah
 * @Date 5/13/21 2:47 PM
 * @Version 1.0
 **/
class Man {
    public String showName(){
        return "Man";
    }
}

class SuperMan extends Man {
    @Override
    public String showName() {
        return super.showName();
    }

    public Man getPerson(){
        return new SuperMan();
    }
}

class SuperSuperMan extends SuperMan{
    @Override
    public SuperMan getPerson(){
        return this;
    }
}
