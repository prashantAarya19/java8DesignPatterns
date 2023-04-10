package designPatterns.creationalDesignPatterns.singleton.basicSingleton;

import org.reflections.Reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class SingletonClass {
    private static final SingletonClass INSTANCE = new SingletonClass();
    public int value;
    private SingletonClass() {
    }

    public static SingletonClass getInstance() {
        return INSTANCE;
    }
}
public class BasicSingleton {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        SingletonClass obj1 = SingletonClass.getInstance();
        obj1.value = 10;

        SingletonClass obj2 = SingletonClass.getInstance();
        obj2.value = 20;

        System.out.println(obj1 == obj2);
        System.out.println(obj1.value +" "+ obj2.value);

        // It's not safe using reflection and serialization
        Constructor<?> declaredConstructor = Class.forName("designPatterns.creationalDesignPatterns.singleton.basicSingleton.SingletonClass").getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        SingletonClass obj3 = (SingletonClass)declaredConstructor.newInstance();
        obj3.value = 40;

        System.out.println(obj1 == obj3);
        System.out.println(obj1.value +" "+ obj3.value);
    }
}
