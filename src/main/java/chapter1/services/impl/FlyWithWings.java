package chapter1.services.impl;

import chapter1.services.FlyBehaviour;

public class FlyWithWings implements FlyBehaviour {
    @Override
    public void fly() {
        System.out.println("Fly with wings");
    }
}
