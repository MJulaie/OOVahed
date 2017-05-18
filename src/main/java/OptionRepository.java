import java.util.ArrayList;

/**
 * Created by Ali on 5/18/2017 AD.
 */
public class OptionRepository {
    private ArrayList<Option> options;
    private static OptionRepository instance = new OptionRepository();

    public static OptionRepository getInstance(){
        return instance;
    }

    private OptionRepository() {


        CourseRepository courseRepository = CourseRepository.getInstance();
        TeacherRepository teacherRepository = TeacherRepository.getInstance();

//        teacher1 = teacherRepository.ge
//        Option option1 = new Option(courseRepository.getCourseByName("a"),
//                )

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
