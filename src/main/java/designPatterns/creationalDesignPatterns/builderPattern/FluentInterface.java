package designPatterns.creationalDesignPatterns.builderPattern;
/*** Fluent builder with recursive generics ***/
class Person {
    public String name;
    public String position;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}

class PersonBuilder<SELF extends PersonBuilder<SELF>> {
    protected Person person = new Person();

    public SELF withName(String name) {
        person.name = name;
        return self();
    }

    public Person build() {
        return person;
    }

    public SELF self() {
        return (SELF) this;
    }
}

class EmployeeBuilder extends PersonBuilder<EmployeeBuilder>{
    public EmployeeBuilder worksAs(String position) {
        person.position = position;
        return this;
    }

    @Override
    public EmployeeBuilder self() {
        return this;
    }
}
public class FluentInterface {
    public static void main(String[] args) {
        Person prashant = new EmployeeBuilder()
                .withName("Prashant")
                // we are not able to call the method worksAs as withName() method returns
                // PersonBuilder.
                // for this we will be needing recursive generics
                // .worksAs("SDE")
                //** After adding the recursive Generics the above method call will work**
                .worksAs("SDE")
                .build();
        System.out.println(prashant);
    }
}
