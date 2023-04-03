package solidPrinciple.interfaceSegrigation;

public class Demo {
}

interface Machine {
    void print();

    void scan();

    void fax();
}

class MultiFuncitonalPrinter implements Machine{
    @Override
    public void print() {
       // provide implementation
    }

    @Override
    public void scan() {
        // provide implementation
    }

    @Override
    public void fax() {
        // provide implementation
    }
}

// Here we are forced to override the method which we don't even needed and broke the IFSP
class OldStylePrinter implements Machine {
    @Override
    public void print() {
        // provide implementation
    }

    @Override
    public void scan() {
        // can't provide implementation
    }

    @Override
    public void fax() {
        // can't provide implementation
    }
}

// Solution for these
interface Printer {
    void print();
}

interface Scanner {
    void scan();
}

interface Faxer {
    void fax();
}

class MultiFunctionalPrinter2 implements  Printer, Scanner, Faxer {
    @Override
    public void print() {
        // provide implementation
    }

    @Override
    public void scan() {
        // provide implementation
    }

    @Override
    public void fax() {
        // provide implementation
    }
}

class OldStylePrinter2 implements Printer {
    @Override
    public void print() {
        // provide implementation
    }
}

