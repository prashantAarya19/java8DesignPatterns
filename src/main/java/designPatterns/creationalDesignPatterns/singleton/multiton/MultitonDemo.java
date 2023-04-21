package designPatterns.creationalDesignPatterns.singleton.multiton;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

enum PrinterSystems {
    PARIMARY,
    AUXULARY,
    FALLBACK
}

class Printer {
    private static int instanceCount = 0;
    private static Map<PrinterSystems, Printer> instances = new HashMap<>();

    private Printer() {
        instanceCount++;
        System.out.println("Instances created so far : "+ instanceCount);
    }

    public static Printer getInstance(PrinterSystems pss) {
        if(instances.containsKey(pss))
            return instances.get(pss);
        Printer instance = new Printer();
        instances.put(pss, instance);
        return instance;
    }
}
public class MultitonDemo {
    public static void main(String[] args) {
        Printer instance1 = Printer.getInstance(PrinterSystems.AUXULARY);
        Printer instance2 = Printer.getInstance(PrinterSystems.AUXULARY);
        Printer instance3 = Printer.getInstance(PrinterSystems.PARIMARY);
        int[] arr  = {1, 2, 4};
        List<int[]> list = Arrays.asList(arr);
    }
}
