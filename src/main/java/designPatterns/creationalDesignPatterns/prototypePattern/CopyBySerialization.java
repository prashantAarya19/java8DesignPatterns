package designPatterns.creationalDesignPatterns.prototypePattern;

import org.apache.commons.lang3.SerializationUtils;

import java.io.Serializable;

class Bike implements Serializable {
    public String name, color;

    public Bike(String name, String color) {
        this.name = name;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Bike{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
public class CopyBySerialization {
    public static void main(String[] args) {
        Bike b1 = new Bike("Apache 320", "Red");
        Bike b2 = SerializationUtils.roundtrip(b1);
        b2.color = "White";

        System.out.println(b1);
        System.out.println(b2);
    }
}
