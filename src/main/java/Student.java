import java.security.acl.Permission;

/**
 * Created by mohammad on 5/17/17.
 */
public class Student extends Person {

    private StudentState studentState;
    private FacultyServices Amoozesh = new Faculty();
    private History history;
    private Barnameh currentBarnameh = new Barnameh();

    public FacultyServices getAmoozesh() {
        return Amoozesh;
    }

    public History getHistory() {
        return history;
    }

    public Student(StudentState studentState) {
        this.studentState = studentState;
    }
}
