import java.util.ArrayList;

/**
 * Created by mohammad on 5/17/17.
 */
public class VahedSelectionService {

    ArrayList<BarnamehPolicyChecker> barnamehRules;
    ArrayList<StudentPolicyChecker> studentRules;

    public VahedSelectionService() {
        /* Add Rules or Removing Dynamicly
         can using Reflection
         */
    }

    public ArrayList<Option> getOptions(StudentInfo studentInfo, History history){
        ArrayList<Course> passedCourses = history.getPassedCourses();
        ArrayList<Course> remainCourses = studentInfo.getRemainCourse(passedCourses);
        return OptionRepository.getInstance().getAvailableOptions(remainCourses);

    }

    private boolean validateBarnameh(Barnameh barnameh,StudentState studentState, History history){
        for(BarnamehPolicyChecker rule : barnamehRules)
            if(!rule.satisfy(barnameh))
                return false;

        for(StudentPolicyChecker rule : studentRules)
            if(!rule.satisfy(barnameh, studentState, history))
                return false;

        return true;
    }

    public boolean Register(Barnameh barnameh, StudentState studentState,History history){
        if(validateBarnameh(barnameh, studentState, history)) {
            history.addBarnameh(barnameh);
            return true;
        }
        return false;
    }

}
