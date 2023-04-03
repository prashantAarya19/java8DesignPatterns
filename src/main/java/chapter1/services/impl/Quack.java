package chapter1.services.impl;

import chapter1.services.QuackBehaviour;

public class Quack implements QuackBehaviour {
    @Override
    public void quack() {
        System.out.println("I can Quack");
    }
}
