import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mohammad on 5/17/17.
 */
public class Chart {

    private ArrayList<Course> courses = new ArrayList<Course>();
    private Map<Course, ArrayList<Course>> Prerequisites = new HashMap<Course, ArrayList<Course>>();


    public void addCourse(Course newCourse){
        courses.add(newCourse);
    }

    public void addCourseWithPrerequisite(Course course, Course prerequisite){
        if(Prerequisites.containsKey(course)){
            Prerequisites.get(course).add(prerequisite);
        } else {
            ArrayList<Course> newCourseList = new ArrayList<Course>();
            newCourseList.add(prerequisite);
            Prerequisites.put(course, newCourseList);
        }
    }


    public ArrayList<Course> getRemainCourses(ArrayList<Course> passedCourses){
        ArrayList<Course> remainCourses = new ArrayList<Course>();

        for (Course course : courses) {
            if (!passedCourses.contains(course)) {
                remainCourses.add(course);
            }
        }
        return remainCourses;
    }

}
