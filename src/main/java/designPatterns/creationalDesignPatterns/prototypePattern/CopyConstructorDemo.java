package designPatterns.creationalDesignPatterns.prototypePattern;

class Address {
    public String street, city, country;

    public Address(String street, String city, String country) {
        this.street = street;
        this.city = city;
        this.country = country;
    }

    public Address(Address otherAddress) {
        this(otherAddress.street, otherAddress.city, otherAddress.country);
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}

class Employee {
    public String name;
    public Address address;

    public Employee(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public Employee(Employee otherEmployee) {
        name = otherEmployee.name;
        address = new Address(otherEmployee.address);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}
public class CopyConstructorDemo {
    public static void main(String[] args) {
        Employee e1 = new Employee("Prashant", new Address("6 anandvihar", "Ludhiana", "India"));
        Employee e2 = new Employee(e1);
        e2.name = "Namrata";
//        e2.address = new Address("1803 Neminath Ocean", "Mumbai", "India");
        e2.address.city = "Mumbai";

        System.out.println(e1);
        System.out.println(e2);
    }
}
