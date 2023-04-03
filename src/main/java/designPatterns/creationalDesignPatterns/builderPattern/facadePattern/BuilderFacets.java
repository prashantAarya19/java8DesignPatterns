package designPatterns.creationalDesignPatterns.builderPattern.facadePattern;

class PersoN {
    // Address info
    public String street, area, city;

    // Employment info
    public String company, designation;
    public Integer earns;

    @Override
    public String toString() {
        return "PersoN{" +
                "street='" + street + '\'' +
                ", area='" + area + '\'' +
                ", city='" + city + '\'' +
                ", company='" + company + '\'' +
                ", designation='" + designation + '\'' +
                ", earns=" + earns +
                '}';
    }
}

class PersoNBuilder {
    protected PersoN person = new PersoN();

    public PersonAddressBuilder lives() {
        return new PersonAddressBuilder(person);
    }

    public PersonEmployementBuilder works() {
        return new PersonEmployementBuilder(person);
    }

    public PersoN build() {
        return person;
    }
}

class PersonAddressBuilder extends PersoNBuilder {

    public PersonAddressBuilder(PersoN person) {
        this.person = person;
    }

    public PersonAddressBuilder street(String street) {
        person.street = street;
        return this;
    }

    public PersonAddressBuilder area(String area) {
        person.area = area;
        return this;
    }

    public PersonAddressBuilder city(String city) {
        person.city = city;
        return this;
    }
}

class PersonEmployementBuilder extends PersoNBuilder{
    public PersonEmployementBuilder(PersoN person) {
        this.person = person;
    }

    public PersonEmployementBuilder worksAt(String company) {
        person.company = company;
        return this;
    }

    public PersonEmployementBuilder as(String designation) {
        person.designation = designation;
        return this;
    }

    public PersonEmployementBuilder earns(Integer earns) {
        person.earns = earns;
        return this;
    }

}
public class BuilderFacets {
    public static void main(String[] args) {
        PersoN build = new PersoNBuilder()
                .lives()
                .area("Phullanwall")
                .works()
                .worksAt("HT Digital")
                .lives()
                .city("Ludhiana")
                .works()
                .earns(170000)
                .lives()
                .street("Street 6")
                .works()
                .as("SDE")
                .build();
        System.out.println(build);
    }
}

