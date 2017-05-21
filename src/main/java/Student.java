import java.security.acl.Permission;
import java.util.ArrayList;

/**
 * Created by mohammad on 5/17/17.
 */
public class Student extends Person {

    private StudentState studentState;
    private StudentInfo studentInfo;
    private FacultyServices Amoozesh;
    private History history;
    private Integer studentNumber;

    public FacultyServices getAmoozesh() {
        return Amoozesh;
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

    public Student(String name, String family, Integer nationalID, Integer studentNumber, Gerayesh gerayesh, Integer enteranceYear) {

        super(name, family, nationalID);
        this.studentNumber = studentNumber;
        this.Amoozesh = new Faculty();
        this.history = new History();
        this.studentState = StudentState.AADI;
        this.studentInfo = new StudentInfo(enteranceYear, gerayesh);
    }

    public StudentState getStudentState() {
        return studentState;
    }

    public boolean isGraduate(){
        Chart studentChart = studentInfo.getChart();
        ArrayList<Course> passedCourses = history.getPassedCourses();
        ArrayList<Course> remainCourses = studentChart.getRemainCourses(passedCourses);
        if (remainCourses.size() == 0){
            System.out.println("TABRIK , TO GRADUATE SHODI :)))) ");
            return true;
        }

        System.out.println("Your remain courses : ");
        for (Course course : remainCourses){
            System.out.println(course);
        }
        return false;
    }

    public void addBarnameh(Barnameh newBarnameh){
        history.addBarnameh(newBarnameh);
    }
}
