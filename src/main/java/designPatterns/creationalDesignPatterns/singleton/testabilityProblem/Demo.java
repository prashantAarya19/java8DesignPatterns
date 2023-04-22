package designPatterns.creationalDesignPatterns.singleton.testabilityProblem;

import com.google.common.collect.Iterables;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

interface Database {
    long getPopulation(String city);
}
class SingletonDatabase implements Database{
    private Dictionary<String, Long> capitals  = new Hashtable<>();
    private static int instanceCount = 0;

    public static int getInstanceCount() {
        return instanceCount;
    }

    private SingletonDatabase() {
        ++instanceCount;
        System.out.println("Instantiating SingletonDatabase");

        try{
            File file = new File(SingletonDatabase.class.getProtectionDomain().getCodeSource().getLocation().getPath());
            Path path = Paths.get(file.getPath(), "city.text");
            List<String> cities = Files.readAllLines(path);
            Iterables.partition(cities, 2)
                    .forEach(
                        e -> capitals.put(e.get(0), Long.parseLong(e.get(1)))
                    );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SingletonDatabase getInstance() {
        SingletonDatabase instance = new SingletonDatabase();
        return instance;
    }

    @Override
    public long getPopulation(String cities) {
        return capitals.get(cities);
    }
}

class SingletonRecordFinder {
    Database database;
    public SingletonRecordFinder(Database database) {
        this.database = database;
    }
    public long population(List<String> cities) {
        long totalPopulation = 0;
        for(String city : cities) {
            totalPopulation += database.getPopulation(city);
        }
        return totalPopulation;
    }
}

class DummyDatabase implements Database {
    private static Dictionary<String, Long> cities = new Hashtable<>();

    public DummyDatabase() {
        cities.put("alpha", 1l);
        cities.put("beta", 2l);
        cities.put("gamma", 3l);
    }

    @Override
    public long getPopulation(String city) {
        try {
            return cities.get(city);
        } catch (NullPointerException ne) {
            return 0;
        }
    }
}

class PopulationTest {
    @Test
    public void getPopulationTest() {
        SingletonRecordFinder instance = new SingletonRecordFinder(new DummyDatabase());
        Assertions.assertEquals(3, instance.population(Arrays.asList("alpha", "beta")));
    }
}
public class Demo {
//    public static void main(String[] args) {
//        SingletonRecordFinder instance = new SingletonRecordFinder();
//        System.out.println( instance.population(Arrays.asList("Ludhiana", "Delhi")) );
//    }
}
