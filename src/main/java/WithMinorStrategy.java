import java.util.ArrayList;

/**
 * Created by Ali on 6/5/2017 AD.
 */
public class WithMinorStrategy extends GraduationStrategy {
    @Override
    public boolean satisfy(StudentInfo studentInfo, History studentHistory) {

        NormalChart studentNormalChart = studentInfo.getNormalChart();
        MinorChart studentMinorChart = studentInfo.getMinorChart();
        ArrayList<Course> passedCourses = studentHistory.getPassedCourses();

        if (studentMinorChart.graduateMinorWithCourses(passedCourses)){

            ArrayList<Course> minorGraduateCourses = studentMinorChart.getGraduateCourses(passedCourses);
            if (studentNormalChart.isGraduateWithMinor(passedCourses, minorGraduateCourses)){
                System.out.println("TABRIK , TO GRADUATE SHODI :)))) ");
                System.out.println("TABRIK , TO MINOR GEREFTI :!!!");
                return true;
            } else {
                this.printRemainCourses(studentNormalChart, passedCourses, minorGraduateCourses);
                return false;
            }

        } else {

            printMinorRemainCourses(studentMinorChart, passedCourses);
            return this.isGraduateOnNormalChart(studentInfo, studentHistory);
        }

    }
}
