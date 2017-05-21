import java.security.PublicKey;
import java.util.ArrayList;

/**
 * Created by Ali on 5/18/2017 AD.
 */
public class CourseRepository {
    private ArrayList<Course> courses = new ArrayList<Course>();
    private static CourseRepository instance = new CourseRepository();

    public static CourseRepository getInstance(){
        return instance;
    }

    private CourseRepository() {
        courses.add(new Course("a", 5, 1420));
        courses.add(new Course("b", 5, 3892));
        courses.add(new Course("c", 5, 3809));
        courses.add(new Course("d", 5, 3891));
        courses.add(new Course("e", 5, 9502));
        courses.add(new Course("f", 5, 9041));
        courses.add(new Course("g", 5, 8493));
        courses.add(new Course("h", 5, 8593));
        courses.add(new Course("i", 5, 8932));
        courses.add(new Course("j", 5, 8913));
        courses.add(new Course("k", 5, 8955));
        courses.add(new Course("l", 5, 4404));
        courses.add(new Course("m", 5, 8888));
        courses.add(new Course("n", 6, 8491));
        courses.add(new Course("o", 6, 8144));

    }

    public void addCourse(Course course){
        courses.add(course);
    }

    public Course getCourseByName(String courseName){
        for (Course course : courses){
            if (course.getName().equals(courseName)){
                return course;
            }
        }
        return null;
    }

}
