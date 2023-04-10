package designPatterns.creationalDesignPatterns.singleton.staticBlock;

import java.io.File;
import java.io.IOException;

public class StaticBlockSingleton {
    private static StaticBlockSingleton instance;
    public int value;
    private StaticBlockSingleton() throws IOException {
        //new File(".", ".");
        System.out.println("Singleton is initializing");
        File.createTempFile(".", ".");
    }

    static {
        try {
            instance = new StaticBlockSingleton();
        } catch (Exception e) {
            System.err.println("Error occurred while creating instance");
        }
    }

    public static StaticBlockSingleton getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        StaticBlockSingleton instance1 = StaticBlockSingleton.getInstance();
        instance1.value = 20;
//        System.out.println(instance1.value);
//
//        StaticBlockSingleton instance2 = StaticBlockSingleton.getInstance();
//        instance2.value = 30;
//
//        System.out.println(instance1 == instance2);
//        System.out.println(instance1.value +" "+ instance2.value);

    }
}
