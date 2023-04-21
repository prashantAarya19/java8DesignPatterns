package designPatterns.creationalDesignPatterns.singleton.testabilityProblem;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

class SingletonDatabase {
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
            //Lists.partition
            Iterables.partition(cities, 2).forEach(
                    e -> capitals.put(e.get(0), Long.parseLong(e.get(1)))
            );
            System.out.println(capitals);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SingletonDatabase getInstance() {
        SingletonDatabase instance = new SingletonDatabase();
        return instance;
    }
}
public class Demo {
    public static void main(String[] args) {
        SingletonDatabase instance = SingletonDatabase.getInstance();
    }
}
