import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by mohammad on 5/17/17.
 */
public class Option {
    private Course course;
    private Teacher teacher;
    private ArrayList<CourseTime> courseTimes = new ArrayList<CourseTime>();
    private SimpleDateFormat examDate = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    private int capacity;
    private String semester;


    public Option(Course course, Teacher teacher, ArrayList<CourseTime> courseTimes, SimpleDateFormat examDate, int capacity, String semester) {
        this.course = course;
        this.teacher = teacher;
        this.courseTimes = courseTimes;
        this.examDate = examDate;
        this.capacity = capacity;
    }

    public int getVahedNumber() {
        return course.getVahedNumber();
    }




}
