package designPatterns.creationalDesignPatterns.singleton.enumBased;

import java.io.*;

enum EnumSingleton {
    INSTANCE;

    EnumSingleton() {
        value = 20;
    }
    private int value;
    void setValue(int value) {
        this.value = value;
    }

    int getValue() {
        return this.value;
    }
}
public class EnumBasedSingleton {

    private static void saveToFile(String fileName, EnumSingleton enumSingleton) throws IOException {
        try(FileOutputStream file = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(file)) {
            out.writeObject(enumSingleton);
        }
    }

    private static EnumSingleton getFromFile(String fileName) throws IOException, ClassNotFoundException {
        try(FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(fis)) {
            return (EnumSingleton) in.readObject();
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        EnumSingleton instance = EnumSingleton.INSTANCE;
//        instance.setValue(40);
//        System.out.println(instance.getValue());
        String fileName = "enumSingleton.bin";
//        saveToFile(fileName, instance);
        EnumSingleton fromFile = getFromFile(fileName);
        System.out.println(fromFile.getValue());
    }
}
