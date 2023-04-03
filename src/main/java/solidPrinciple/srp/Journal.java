package solidPrinciple.srp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Journal {
    private final List<String> entries = new ArrayList<>();
    private static int count = 0;

    public void addJournal(String entry) {
        entries.add(""+ ++count + " : "+ entry);
    }

    public void remove(int index) {
        entries.remove(index);
        --count;
    }

    // Broke SRP as we have added persistent logic into the Journal class
    public void saveToFile(String filename) throws FileNotFoundException {
        try(PrintStream out = new PrintStream(filename)) {
            out.println(toString());
        }
    }

    @Override
    public String toString() {
        return String.join(System.lineSeparator(), entries);
    }
}

// Took out the persistence logic out of Journal class
class Persistence {
    public void saveToFiles(Journal journal, String filename, boolean isOverwrite) throws FileNotFoundException{
        if(isOverwrite || new File(filename).exists()) {
            try (PrintStream out = new PrintStream(filename)) {
                out.println(journal.toString());
            }
        }
    }
}

class SRPDemo {
    public static void main(String[] args) throws Exception{
        Journal j = new Journal();
        j.addJournal("I am happy today");
        j.addJournal("I have started design pattern course");
        j.addJournal("It's day 2");
        //j.saveToFile("journal.text");

        //Runtime.getRuntime().exec("notepad D:\\WorkSpace\\designPatterns\\journal.text");
        Persistence p = new Persistence();
        p.saveToFiles(j, "journal.text", true);
        Runtime.getRuntime().exec("notepad D:\\WorkSpace\\designPatterns\\journal.text");
    }
}
