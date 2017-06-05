import java.util.ArrayList;

/**
 * Created by mohammad on 5/21/17.
 */
public abstract class GraduationStrategy {
    public abstract boolean satisfy(StudentInfo studentInfo, History studentHistory);

    protected void printRemainCourses(NormalChart normalChart, ArrayList<Course> passedCourses){
        ArrayList<Course> remainNormalCourses = normalChart.getRemainCourses(passedCourses);
        ArrayList<Course> remainOptionalCourses = normalChart.getRemainOptionalCourse(passedCourses);
        System.out.println("Your remain courses : ");
        System.out.println("NORMAL COURSES : ");
        for (Course course : remainNormalCourses){
            System.out.println(course);
        }

        System.out.println("OPTIONAL COURSES : ");
        for (Course course : remainOptionalCourses){
            System.out.println(course);
        }
    }
    protected void printRemainCourses(NormalChart normalChart, ArrayList<Course> passedCourses, ArrayList<Course> minorGraduateCourses){
        ArrayList<Course> remainNormalCourses = normalChart.getRemainCourses(passedCourses);
        ArrayList<Course> remainOptionalCourses = normalChart.getRemainOptionalCourse(passedCourses, minorGraduateCourses);

        System.out.println("Your remain courses : ");
        System.out.println("NORMAL COURSES : ");
        for (Course course : remainNormalCourses){
            System.out.println(course);
        }

        System.out.println("OPTIONAL COURSES : ");
        for (Course course : remainOptionalCourses){
            System.out.println(course);
        }
    }
    protected boolean isGraduateOnNormalChart(StudentInfo studentInfo, History studentHistory){
        NormalChart studentChart = studentInfo.getNormalChart();
        ArrayList<Course> passedCourses = studentHistory.getPassedCourses();
        if (studentChart.isGraduateNormal(passedCourses)){
            System.out.println("TABRIK , TO GRADUATE SHODI :)))) ");
            return true;

        } else {
            printRemainCourses(studentChart, passedCourses);
            return false;
        }

    }
}
