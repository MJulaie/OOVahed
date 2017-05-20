import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

import java.util.Date;

/**
 * Created by Ali on 5/20/2017 AD.
 */
public class ExamDate {
    private TimeInterval examTime;
    private LocalDate examDate;


    public ExamDate(LocalDate examDate, TimeInterval examTime) {
        this.examTime = examTime;
        this.examDate = examDate;
    }

    public LocalTime getStartTime(){ return examTime.getStartTime();}
    public LocalTime getEndTime() { return examTime.getEndTime();}

    public boolean hasOverlap(ExamDate anotherExamDate){
        return examDate.equals(anotherExamDate) && examTime.hasOverlap(anotherExamDate.examTime);
    }
}
