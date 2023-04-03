package chapter1.services.impl;

import chapter1.services.QuackBehaviour;

public class MuteQuack implements QuackBehaviour {
    @Override
    public void quack() {
        System.out.println("Mute");
    }
}
