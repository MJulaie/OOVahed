/**
 * Created by mohammad on 5/17/17.
 */
public abstract class Person {

    protected String name;
    protected String lastName;
    protected Integer nationalID;

    public Person(String name, String lastName, Integer nationalID) {
        this.name = name;
        this.lastName = lastName;
        this.nationalID = nationalID;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getNationalID() {
        return nationalID;
    }
}
