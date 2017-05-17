import java.text.SimpleDateFormat;

/**
 * Created by Ali on 5/17/2017 AD.
 */
public class CourseTime {
    private String dayOfWeek;
    private SimpleDateFormat startTime = new SimpleDateFormat("HH:mm");
    private SimpleDateFormat endTime = new SimpleDateFormat("HH:mm");

    public CourseTime(String dayOfWeek, SimpleDateFormat startTime, SimpleDateFormat endTime) {
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
