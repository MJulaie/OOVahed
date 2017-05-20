import java.util.ArrayList;

/**
 * Created by mohammad on 5/19/17.
 */
public class DuplicateCourseChecker extends StudentPolicyChecker {

    @Override
    public boolean satisfy(Barnameh barnameh, StudentState studentState, History history) {

        ArrayList<Course> passedCourse = history.getPassedCourses();

        for(Course course : passedCourse){
            if(barnameh.hasCourse(course))
                return false;
        }

        return true;
    }
}
