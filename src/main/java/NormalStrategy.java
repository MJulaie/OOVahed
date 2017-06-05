import java.util.ArrayList;

/**
 * Created by mohammad on 5/21/17.
 */
public class NormalStrategy extends GraduationStrategy {
    @Override
    public boolean satisfy(StudentInfo studentInfo, History studentHistory) {
        if (this.isGraduateOnNormalChart(studentInfo, studentHistory)){
            System.out.println("TABRIK , TO GRADUATE SHODI :)))) ");
            return true;
        } else
        return this.isGraduateOnNormalChart(studentInfo, studentHistory);
    }
}
