package designPatterns.creationalDesignPatterns.singleton.innerStaticSingleton;

public class InnerStaticSingleton {
    public int value;
    private InnerStaticSingleton() {
        System.out.println("Outer class constructor");
    }

    private static class Impl {
        private static final InnerStaticSingleton INSTANCE = new InnerStaticSingleton();
    }
    public static InnerStaticSingleton getInstance() {
        return Impl.INSTANCE;
    }

    public static void main(String[] args) {
        InnerStaticSingleton instance1 = InnerStaticSingleton.getInstance();
        instance1.value = 20;
        System.out.println(instance1.value);

        InnerStaticSingleton instance2 = InnerStaticSingleton.getInstance();
        instance2.value = 30;

        System.out.println(instance1 == instance2);
        System.out.println(instance1.value +" "+ instance2.value);
    }
}
