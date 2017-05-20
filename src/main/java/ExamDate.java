import java.util.Date;

/**
 * Created by Ali on 5/20/2017 AD.
 */
public class ExamDate {
    private Date startTime;
    private Date endTime;
    private Date examDate;


    public ExamDate(Date examDate, Date startTime, Date endTime) {
        this.examDate = examDate;
        this.startTime = startTime;
        this.endTime = endTime;
    }


}
