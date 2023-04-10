package designPatterns.creationalDesignPatterns.singleton.lazySingleton;

import designPatterns.creationalDesignPatterns.singleton.staticBlock.StaticBlockSingleton;

public class LazySingleton {
    private static LazySingleton instance;
    public int value;
    private LazySingleton() {

    }

      // It's not thread safe and there could be a chance of multiple threads get created
//    public static LazySingleton getInstance() {
//        if(instance == null) {
//            instance = new LazySingleton();
//        }
//        return instance;
//    }

    public static LazySingleton getInstance() {
        if(instance == null) {
            synchronized (LazySingleton.class) {
                if(instance == null)
                    instance = new LazySingleton();
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        LazySingleton instance1 = LazySingleton.getInstance();
        instance1.value = 20;
        System.out.println(instance1.value);

        LazySingleton instance2 = LazySingleton.getInstance();
        instance2.value = 30;

        System.out.println(instance1 == instance2);
        System.out.println(instance1.value +" "+ instance2.value);
    }

}
