package designPatterns.creationalDesignPatterns.singleton.serializationProof;

import java.io.*;

class SingletonClass implements Serializable {
    private static final SingletonClass INSTANCE = new SingletonClass();
    public int value;
    private SingletonClass() {
    }

    public static SingletonClass getInstance() {
        return INSTANCE;
    }

    // for making it to work over serialization
    protected Object readResolve() {
        return INSTANCE;
    }
}

class SerializationUtil {
    public static void saveToFile(String filename, SingletonClass singletonClass) throws Exception {
        try(FileOutputStream fileOut = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(singletonClass);
        }
    }

    public static SingletonClass readFromFile(String filename) throws Exception{
        try(FileInputStream fileIn = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(fileIn)) {
            return (SingletonClass) in.readObject();
        }
    }
}
public class SerializationProof {
    public static void main(String[] args) throws Exception {
        SingletonClass instance1 = SingletonClass.getInstance();
        instance1.value = 20;

        String fileName = "singleton.bin";
        SerializationUtil.saveToFile(fileName, instance1);
        SingletonClass instance2 = SerializationUtil.readFromFile(fileName);
        instance2.value = 30;

        System.out.println(instance1 == instance2);
        System.out.println(instance1.value+" "+ instance2.value);
    }
}
