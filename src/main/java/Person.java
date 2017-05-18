/**
 * Created by mohammad on 5/17/17.
 */
public abstract class Person {

    protected String name;
    protected String family;
    protected Integer nationalID;

    public Person(String name, String family, Integer nationalID) {
        this.name = name;
        this.family = family;
        this.nationalID = nationalID;
    }
}
