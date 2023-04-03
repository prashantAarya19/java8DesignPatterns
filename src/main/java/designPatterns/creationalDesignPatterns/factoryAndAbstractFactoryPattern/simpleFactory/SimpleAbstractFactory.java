package designPatterns.creationalDesignPatterns.factoryAndAbstractFactoryPattern.simpleFactory;

import org.reflections.Reflections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        System.out.printf("Put in tea bag, boil water, pour %s ml, add lemon, enjoy!%n", amount);
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
            Class<?> factory = Class.forName(String.format("designPatterns.creationalDesignPatterns.factoryAndAbstractFactoryPattern.simpleFactory.%sFactory", factoryName));
            factories.put(drink, (IHotDrinkFactory) factory.getDeclaredConstructor().newInstance());
        }

        // Find all implementors of IHotDrinkFactory
        Set<Class<? extends IHotDrinkFactory>> types = new Reflections("designPatterns.creationalDesignPatterns.factoryAndAbstractFactoryPattern.simpleFactory")
                .getSubTypesOf(IHotDrinkFactory.class);
        for(Class<? extends IHotDrinkFactory> type : types) {
            namedFactories.add(
                    new Pair<>(
                            type.getSimpleName().replace("Factory", ""),
                            type.getDeclaredConstructor().newInstance()
                    )
            );
        }

    }

    public IHotDrink makeDrink() throws IOException {
        System.out.println("Available Drinks");
        for(int index = 0; index < namedFactories.size(); index++) {
            Pair<String, IHotDrinkFactory> items = namedFactories.get(index);
            System.out.printf(" %d : %s \n", index, items.t1);
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            String s;
            int i, amount;
            if((s = reader.readLine()) != null
                && (i = Integer.parseInt(s)) >= 0
                && (i < namedFactories.size())) {
                System.out.println("Specify amount : ");
                s = reader.readLine();

                if(s != null && (amount = Integer.parseInt(s)) > 0) {
                    return namedFactories.get(i).t2.prepare(amount);
                }
            }
            System.out.println("Incorrect input, try again.");
        }
    }

}

public class SimpleAbstractFactory {
    public static void main(String[] args) throws Exception {
//        IHotDrinkFactory coffeeFactory = new CoffeeFactory();
//        coffeeFactory.prepare(30);
//        IHotDrinkFactory teaFactory = new TeaFactory();
//        teaFactory.prepare(20);
        HotDrinkMachine machine = new HotDrinkMachine();
        machine.makeDrink();
    }
}
