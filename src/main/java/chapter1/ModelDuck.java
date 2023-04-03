package chapter1;

import chapter1.abstractType.Duck;
import chapter1.services.impl.FlyNoWay;
import chapter1.services.impl.Quack;

public class ModelDuck extends Duck {

    public ModelDuck() {
        this.flyBehaviour = new FlyNoWay();
        this.quackBehaviour = new Quack();
    }
    @Override
    public void display() {
        System.out.println("I am a model Duck");
    }
}
