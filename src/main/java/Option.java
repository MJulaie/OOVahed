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
    private int optionID;


    public Option(Course course, Teacher teacher, CourseSlot courseSlot, ExamDate examDate, int capacity,int semesterID, int optionID) {
        this.course = course;
        this.teacher = teacher;
        this.courseTimes.add(courseSlot);
        this.examDate = examDate;
        this.capacity = capacity;
        this.semesterID = semesterID;
        this.optionID = optionID;
        this.available = true;
    }

    public int getVahedNumber() {
        return course.getVahedNumber();
    }

    public int getOptionID() {
        return optionID;
    }

    public boolean isAvailable(){
        return available;
    }

    public Course getCourse() {
        return course;
    }

    public ArrayList<CourseSlot> getCourseTimes() {
        return courseTimes;
    }


    public boolean haveCapacity(){
        return this.capacity >= 0;
    }

    public void decreaseCapacity(){
        this.capacity -= 1;
    }

    public void increaseCapacity() { this.capacity += 1; }

    public void addCourseSlot(CourseSlot courseSlot){
        this.courseTimes.add(courseSlot);
    }

    public boolean hasOverlap(Option option){

        for(CourseSlot courseTime : courseTimes)
            for(CourseSlot optionCourseTime : option.getCourseTimes())
                if(courseTime.hasOverlap(optionCourseTime))
                    return true;
        if(examDate.equals(option.examDate))
            return true;
        return false;
    }

    @Override
    public String toString() {
        return course.getName() + "  |  "
                + teacher.getName() + " "
                + teacher.getLastName() + "  |  "
                + courseTimes.get(0).toString() + " | size : "
                + (capacity >= 0 ? capacity : 0);
    }
}