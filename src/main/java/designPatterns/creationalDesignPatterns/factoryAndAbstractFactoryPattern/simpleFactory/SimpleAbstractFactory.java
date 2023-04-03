package designPatterns.creationalDesignPatterns.factoryAndAbstractFactoryPattern.simpleFactory;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

interface IHotDrink {
    void consume();
}

class Tea implements IHotDrink {
    @Override
    public void consume() {
        System.out.println("This tea is nice");
    }
}

class Coffee implements IHotDrink {
    @Override
    public void consume() {
        System.out.println("This coffee is delicious");
    }
}

interface IHotDrinkFactory {
    IHotDrink prepare(int amount);
}

class TeaFactory implements IHotDrinkFactory {
    @Override
    public IHotDrink prepare(int amount) {
        System.out.printf("Put in tea bag, boil water, pour %svml, add lemon, enjoy!%n", amount);
        return new Tea();
    }
}

class CoffeeFactory implements IHotDrinkFactory {
    @Override
    public IHotDrink prepare(int amount) {
        System.out.printf("Grind some beans, boil water, pour %s ml, add cream and sugar, enjoy!\n", amount);
        return new Coffee();
    }
}

// Abstract factory starts
class Pair<T1, T2> {
    public T1 t1;
    public T2 t2;

    public Pair() {

    }

    public Pair(T1 t1, T2 t2) {
        this.t1 = t1;
        this.t2 = t2;
    }
}
class HotDrinkMachine {
    public enum AvailableHotDrink {
        TEA, COFFEE
    }

    private Map<AvailableHotDrink, IHotDrinkFactory> factories = new HashMap<>();
    private List<Pair<String, IHotDrinkFactory>> namedFactories = new ArrayList<>();

    public HotDrinkMachine() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        for(AvailableHotDrink drink : AvailableHotDrink.values()) {
            String drinkName = drink.toString();
            String factoryName = ""+Character.toUpperCase(drinkName.charAt(0))+drinkName.substring(1).toLowerCase();
            Class<?> factory = Class.forName(String.format("%sFactory", factoryName));
            factories.put(drink, (IHotDrinkFactory) factory.getDeclaredConstructor().newInstance());
        }

        // Find all implementors of IHotDrinkFactory
        //new Reflections("")
    }

}

public class SimpleAbstractFactory {
    public static void main(String[] args) {
        IHotDrinkFactory coffeeFactory = new CoffeeFactory();
        coffeeFactory.prepare(30);
        IHotDrinkFactory teaFactory = new TeaFactory();
        teaFactory.prepare(20);
    }
}
