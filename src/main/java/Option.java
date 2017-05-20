import java.util.ArrayList;

/**
 * Created by mohammad on 5/17/17.
 */
public class Option {
    private Course course;
    private Teacher teacher;
    private ArrayList<CourseSlot> courseTimes = new ArrayList<CourseSlot>();
    private ExamDate examDate;
    private int capacity;
    private int semesterID;
    private boolean available;


    public Option(Course course, Teacher teacher, CourseSlot courseSlot, ExamDate examDate, int capacity,int semesterID) {
        this.course = course;
        this.teacher = teacher;
        this.courseTimes.add(courseSlot);
        this.examDate = examDate;
        this.capacity = capacity;
        this.semesterID = semesterID;
        this.available = true;
    }

    public int getVahedNumber() {
        return course.getVahedNumber();
    }

    public boolean isAvailable(){
        return available;
    }

    public Course getCourse() {
        return course;
    }

    public boolean haveCapacity(){
        return this.capacity > 0;
    }

    public void decreaseCapacity(){
        this.capacity -= 1;
    }

    public void addCourseSlot(CourseSlot courseSlot){
        this.courseTimes.add(courseSlot);
    }

    public boolean hasOverlap(Option option){

        for(CourseSlot courseTime : courseTimes)
            for(CourseSlot optionCourseTime : option.courseTimes)
                if(courseTime.hasOverlap(optionCourseTime))
                    return false;
        if(examDate.equals(option.examDate))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return course.getName() + "  |  " + teacher.getName() + " " + teacher.getLastName() + "  |  " + courseTimes.get(0).toString();
    }
}