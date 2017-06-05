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
        return graduationService.validateGraduation(studentInfo, studentHistory);
    }
}
