package designPatterns.creationalDesignPatterns.singleton.monostate;

class ChiefExecutiveOfficer {
    private static String name;
    private static String designation;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        ChiefExecutiveOfficer.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        ChiefExecutiveOfficer.designation = designation;
    }

    @Override
    public String toString() {
        return "ChiefExecutiveOfficer{" +
                "name='" + name + '\'' +
                ", designation='" + designation + '\'' +
                '}';
    }
}
public class MonostateDemo {
    public static void main(String[] args) {
        ChiefExecutiveOfficer ceo1 = new ChiefExecutiveOfficer();
        ceo1.setName("Prashant");
        ceo1.setDesignation("CEO");

        ChiefExecutiveOfficer ceo2 = new ChiefExecutiveOfficer();
        System.out.println(ceo2);

    }
}
