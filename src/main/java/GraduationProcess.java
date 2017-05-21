import java.util.ArrayList;

/**
 * Created by mohammad on 5/21/17.
 */
public class GraduationProcess {

    private Student student;
    private GraduationService graduationService;

    public GraduationProcess(Student student) {
        this.student = student;
        this.graduationService = student.getFacultyServices().getGraduationService();
    }

    public boolean isGraduate(){
        StudentInfo studentInfo = student.getStudentInfo();
        History studentHistory = student.getHistory();
        Chart studentChart = studentInfo.getChart();
        ArrayList<Course> passedCourses = studentHistory.getPassedCourses();
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
}
