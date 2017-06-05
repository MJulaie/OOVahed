import java.security.acl.Permission;
import java.util.ArrayList;

/**
 * Created by mohammad on 5/17/17.
 */
public class Student extends Person {

    private StudentState studentState;
    private StudentInfo studentInfo;
    private Faculty facultyServices;
    private History history;
    private Integer studentNumber;

    public FacultyServices getAmoozesh() {
        return facultyServices;
    }

    public History getHistory() {
        return history;
    }

    public StudentInfo getStudentInfo() {
        return studentInfo;
    }

    public Integer getStudentNumber() {
        return studentNumber;
    }

    public Faculty getFacultyServices() {
        return facultyServices;
    }

    public Student(String name, String family, Integer nationalID, Integer studentNumber, Gerayesh gerayesh, Integer enteranceYear) {

        super(name, family, nationalID);
        this.studentNumber = studentNumber;
        this.facultyServices = new Faculty();
        this.history = new History();
        this.studentState = StudentState.AADI;
        this.studentInfo = new StudentInfo(enteranceYear, gerayesh);
    }

    public void setMinor(Minor minor){
        studentInfo.setMinor(minor);
    }
    public StudentState getStudentState() {
        return studentState;
    }

    public void addBarnameh(Barnameh newBarnameh){
        history.addBarnameh(newBarnameh);
    }
}
