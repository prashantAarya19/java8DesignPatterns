package chapter1;

import chapter1.abstractType.Duck;
import chapter1.services.impl.FlyNoWay;
import chapter1.services.impl.Quack;

public class MallardDuck extends Duck {
    public MallardDuck() {
        flyBehaviour = new FlyNoWay();
        quackBehaviour = new Quack();
    }

    @Override
    public void display() {
        System.out.println("I am Mallard duck");
    }
}
