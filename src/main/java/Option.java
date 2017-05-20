import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by mohammad on 5/17/17.
 */
public class Option {
    private Course course;
    private Teacher teacher;
    private ArrayList<CourseTime> courseTimes = new ArrayList<CourseTime>();
    private ExamDate examDate;
    private int capacity;
    private int semesterID;
    private boolean available;


    public Option(Course course, Teacher teacher, CourseTime courseTime, ExamDate examDate, int capacity, Integer semesterID) {
        this.course = course;
        this.teacher = teacher;
        this.courseTimes.add(courseTime);
        this.examDate = examDate;
        this.capacity = capacity;
        this.semesterID = semesterID;
        this.available = true;
    }

    public int getVahedNumber() { return course.getVahedNumber(); }

    public void addCourseTime(CourseTime newCourseTime){
        courseTimes.add(newCourseTime);
    }

    public boolean isAvailable(){
        return available;
    }

    public void setAvailablity(boolean availablityState){
        this.available = availablityState;
    }
    public Course getCourse() {
        return course;
    }
}
