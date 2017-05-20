import java.security.acl.Permission;

/**
 * Created by mohammad on 5/17/17.
 */
public class Student extends Person {

    private StudentState studentState;
    private StudentInfo studentInfo;
    private FacultyServices Amoozesh;
    private History history;
    private Barnameh currentBarnameh;

    public FacultyServices getAmoozesh() {
        return Amoozesh;
    }

    public History getHistory() {
        return history;
    }

    public StudentInfo getStudentInfo() {
        return studentInfo;
    }


    public Student(String name, String family, Integer nationalID, Gerayesh gerayesh, Integer enteranceYear) {

        super(name, family, nationalID);
        this.currentBarnameh = new Barnameh();
        this.Amoozesh = new Faculty();
        this.history = new History();
        this.studentState = StudentState.AADI;
        this.studentInfo = new StudentInfo(enteranceYear, gerayesh);
    }

    public StudentState getStudentState() {
        return studentState;
    }
}
