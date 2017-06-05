/**
 * Created by mohammad on 5/21/17.
 */
public class GraduationService {

    GraduationStrategy graduationStrategy;

    public boolean validateGraduation(StudentInfo studentInfo, History history){
        if (studentInfo.hasMinor()){
            graduationStrategy = new WithMinorStrategy();
        } else {
            graduationStrategy = new NormalStrategy();
        }

        return graduationStrategy.satisfy(studentInfo, history);
    }

    public boolean graduate(Student student){
        return false;
    }
}
