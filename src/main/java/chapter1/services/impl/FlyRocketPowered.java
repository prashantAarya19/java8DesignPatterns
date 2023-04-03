package chapter1.services.impl;

import chapter1.services.FlyBehaviour;

public class FlyRocketPowered implements FlyBehaviour {
    @Override
    public void fly() {
        System.out.println("I am flying with a rocket");
    }
}
