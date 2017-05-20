import org.joda.time.LocalTime;

/**
 * Created by Ali on 5/17/2017 AD.
 */
public class CourseSlot {
    private String dayOfWeek;
    private TimeInterval courseTime;


    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public CourseSlot(String dayOfWeek, TimeInterval courseTime) {
        this.dayOfWeek = dayOfWeek;
        this.courseTime = courseTime;
    }

    public LocalTime getStartTime(){ return courseTime.getStartTime();}
    public LocalTime getEndTime() { return courseTime.getEndTime();}

    public boolean hasOverlap(CourseSlot courseSlot){
        return  dayOfWeek.equals(courseSlot.getDayOfWeek())
                && courseTime.hasOverlap(courseSlot.courseTime);
    }
}