import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Ali on 5/18/2017 AD.
 */
public class OptionRepository {
    private ArrayList<Option> options;

    private static OptionRepository instance;
    static {
        try {
            instance = new OptionRepository();
        } catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static OptionRepository getInstance(){
        return instance;
    }

    private OptionRepository() throws ParseException {

        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");


        CourseRepository courseRepository = CourseRepository.getInstance();
        TeacherRepository teacherRepository = TeacherRepository.getInstance();

        Teacher teacher1 = teacherRepository.getTeacherByID(91919);
        Teacher teacher2 = teacherRepository.getTeacherByID(91842);
        Teacher teacher3 = teacherRepository.getTeacherByID(19042);

        Course course1 = courseRepository.getCourseByName("a");
        Course course2 = courseRepository.getCourseByName("b");
        Course course3 = courseRepository.getCourseByName("c");
        Course course4 = courseRepository.getCourseByName("d");
        Course course5 = courseRepository.getCourseByName("e");

        CourseTime courseTime1 = new CourseTime("shanbeh", timeFormat.parse("10:30"), timeFormat.parse("12:00"));
        CourseTime courseTime2 = new CourseTime("shanbeh", timeFormat.parse("15:30"), timeFormat.parse("17:00"));
        CourseTime courseTime3 = new CourseTime("yekshanbeh", timeFormat.parse("9:00"), timeFormat.parse("10:30"));
        CourseTime courseTime4 = new CourseTime("doshanbeh", timeFormat.parse("9:00"), timeFormat.parse("10:30"));
        CourseTime courseTime5 = new CourseTime("doshanbeh", timeFormat.parse("10:30"), timeFormat.parse("12:00"));

        ExamDate examDate1 = new ExamDate(dateFormat.parse("1396-3-2"), timeFormat.parse("14:30"), timeFormat.parse("18:00"));
        ExamDate examDate2 = new ExamDate(dateFormat.parse("1396-3-3"), timeFormat.parse("14:30"), timeFormat.parse("18:00"));
        ExamDate examDate3 = new ExamDate(dateFormat.parse("1396-3-4"), timeFormat.parse("12:30"), timeFormat.parse("15:30"));
        ExamDate examDate4 = new ExamDate(dateFormat.parse("1396-3-4"), timeFormat.parse("14:30"), timeFormat.parse("17:30"));
        ExamDate examDate5 = new ExamDate(dateFormat.parse("1396-3-5"), timeFormat.parse("9:00"), timeFormat.parse("12:30"));

        Option option1 = new Option(course1, teacher1, courseTime1, examDate1, 30, 13962);
        Option option2 = new Option(course1, teacher2, courseTime2, examDate2, 25, 13962);
        Option option3 = new Option(course2, teacher2, courseTime5, examDate3, 25, 13962);
        Option option4 = new Option(course3, teacher3, courseTime3, examDate4, 45, 13962);
        Option option5 = new Option(course4, teacher3, courseTime4, examDate5, 55, 13962);
        Option option6 = new Option(course5, teacher1, courseTime5, examDate5, 55, 13962);
        Option option7 = new Option(course5, teacher1, courseTime3, examDate1, 25, 13962);

        options.add(option1);
        options.add(option2);
        options.add(option3);
        options.add(option4);
        options.add(option5);
        options.add(option6);
        options.add(option7);

    }

    public ArrayList<Option> getAvailableOptions(ArrayList<Course> remainCourses) {
        ArrayList<Option> availableOptions = new ArrayList<Option>();

        for(Course course : remainCourses) {
            for(Option option : options){
                if (option.isAvailable()){
                    if (option.getCourse().equals(course)){
                        availableOptions.add(option);
                    }
                }
            }
        }
        return availableOptions;
    }
}
