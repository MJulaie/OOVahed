import java.util.ArrayList;

/**
 * Created by mohammad on 5/19/17.
 */
public class PishniaziChecker extends StudentPolicyChecker {

    @Override
    public boolean satisfy(Barnameh barnameh, StudentState studentState, History history) {
        return false;
    }

    public boolean satisfy(Barnameh barnameh, StudentState studentState, History history, StudentInfo studentInfo){

        Chart studentChart = studentInfo.getChart();
        ArrayList<Course> passedCourses = history.getPassedCourses();

        ArrayList<Course> selectedCourses = barnameh.getCourses();

        for(Course course : selectedCourses){

            if(!passedCourses.containsAll(studentChart.getPrerequisities(course)))
                return false;
        }

        return true;
    }
}
