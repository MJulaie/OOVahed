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
        courses.add(new Course("a", 3));
        courses.add(new Course("b", 3));
        courses.add(new Course("c", 3));
        courses.add(new Course("d", 3));
        courses.add(new Course("e", 3));
        courses.add(new Course("f", 3));
        courses.add(new Course("g", 3));
        courses.add(new Course("h", 2));
        courses.add(new Course("i", 3));
        courses.add(new Course("j", 2));
        courses.add(new Course("k", 3));
        courses.add(new Course("l", 3));

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
