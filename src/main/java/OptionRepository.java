import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by Ali on 5/18/2017 AD.
 */
public class OptionRepository {
    private ArrayList<Option> options = new ArrayList<Option>();

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

        CourseSlot courseTime1 = new CourseSlot("shanbeh",new TimeInterval(10,30,12,0));
        CourseSlot courseTime2 = new CourseSlot("shanbeh",new TimeInterval(15,30,17,0));
        CourseSlot courseTime3 = new CourseSlot("yekshanbeh", new TimeInterval(9,0,10,30));
        CourseSlot courseTime4 = new CourseSlot("doshanbeh", new TimeInterval(9,0,10,30));
        CourseSlot courseTime5 = new CourseSlot("doshanbeh", new TimeInterval(10,30,12,0));

        ExamDate examDate1 = new ExamDate(new LocalDate(1396,3,2), new TimeInterval(14,30,18,0));
        ExamDate examDate2 = new ExamDate(new LocalDate(1396,3,3), new TimeInterval(14 ,30,18,0));
        ExamDate examDate3 = new ExamDate(new LocalDate(1396,3,4), new TimeInterval(12,30,15,0));
        ExamDate examDate4 = new ExamDate(new LocalDate(1396,3,5), new TimeInterval(14,30,17,30));
        ExamDate examDate5 = new ExamDate(new LocalDate(1396,3,6), new TimeInterval(9,0,10,30));

        Option option1 = new Option(course1, teacher1, courseTime1, examDate1, 0, 13962);
        Option option2 = new Option(course1, teacher2, courseTime2, examDate2, 0, 13962);
        Option option3 = new Option(course2, teacher2, courseTime5, examDate3, 1, 13962);
        Option option4 = new Option(course3, teacher3, courseTime3, examDate4, 1, 13962);
        Option option5 = new Option(course4, teacher3, courseTime4, examDate5, 1, 13962);
        Option option6 = new Option(course5, teacher1, courseTime5, examDate5, 1, 13962);
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
//            System.out.println("remainCourse name : " + course.getName());
            for(Option option : options){
//                System.out.println("remainCourse name : " + option.toString());
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
