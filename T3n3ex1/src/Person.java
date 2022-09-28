public class Person {
    private String name;
    private String lastName;
    private String DNI;

    public Person() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public Person(String name, String lastName, String DNI) {
        this.name = name;
        this.lastName = lastName;
        this.DNI = DNI;
    }
}
