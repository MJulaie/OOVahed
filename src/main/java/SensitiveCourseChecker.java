import java.util.ArrayList;

/**
 * Created by mohammad on 5/19/17.
 */
public class SensitiveCourseChecker extends BarnamehPolicyChecker {

    ArrayList<Course> sensitiveCourses = new ArrayList<Course>();

    public SensitiveCourseChecker() {
        CourseRepository courseRepository = CourseRepository.getInstance();
        this.sensitiveCourses.add(courseRepository.getCourseByName("Karamoozi"));
    }

    @Override
    public boolean satisfy(Barnameh barnameh) {
        for(Course course : sensitiveCourses)
            if(barnameh.hasCourse(course)){
                System.out.println("You have sensitive course like karamoozi! remove it : )");
                return false;
            }
        return true;
    }
}
