import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Ali on 5/17/2017 AD.
 */
public class CourseTime {
    private String dayOfWeek;
    private Date startTime;
    private Date endTime;

    public CourseTime(String dayOfWeek, Date startTime, Date endTime) {
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;


    }
}
