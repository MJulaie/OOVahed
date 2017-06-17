import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by mohammad on 5/17/17.
 */
public class VahedSelectionService {

    ArrayList<BarnamehPolicyChecker> barnamehRules ;
    ArrayList<StudentPolicyChecker> studentRules;

    public VahedSelectionService() {
        this.barnamehRules = new ArrayList<BarnamehPolicyChecker>();
        this.studentRules = new ArrayList<StudentPolicyChecker>();

        barnamehRules.add(new CapacityChecker());
        barnamehRules.add(new TimeCompatibilityChecker());

        studentRules.add(new VahedNumberChecker());
        /* Add Rules or Removing Dynamicly
         can using Reflection
         */
    }

    public ArrayList<Option> getOptions(StudentInfo studentInfo, History history){
        ArrayList<Course> passedCourses = history.getPassedCourses();
        ArrayList<Course> remainCourses = studentInfo.getRemainCourse(passedCourses);

        ArrayList<Option> availableOptions = OptionRepository.getInstance().getAvailableOptions(remainCourses);
        Set<Option> tempArray = new HashSet<Option>();
        tempArray.addAll(availableOptions);
        availableOptions.clear();
        availableOptions.addAll(tempArray);

        return availableOptions;

    }

    public boolean validateBarnameh(Barnameh barnameh,StudentState studentState, History history){
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
