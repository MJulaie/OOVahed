import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

import java.sql.Time;

/**
 * Created by mohammad on 5/20/17.
 */
public class TimeInterval {
    private LocalTime startTime;
    private LocalTime endTime;

    public TimeInterval(LocalTime startTime, LocalTime endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public TimeInterval(int startHour,int startMinute,int endHour,int endMinute){
        this.startTime = new LocalTime(startHour,startMinute);
        this.endTime = new LocalTime(endHour,endMinute);
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public boolean hasOverlap(TimeInterval timeInterval){
        return startTime.isBefore(timeInterval.getEndTime())
                && timeInterval.getStartTime().isBefore(endTime);
    }
}
