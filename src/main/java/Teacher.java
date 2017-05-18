/**
 * Created by mohammad on 5/17/17.
 */
public class Teacher extends Person {
    private Integer enteranceYear;

    public Teacher(String name, String family, Integer enteranceYear, Integer nationalID) {
        super(name, family, nationalID);
        this.enteranceYear = enteranceYear;
    }
}
