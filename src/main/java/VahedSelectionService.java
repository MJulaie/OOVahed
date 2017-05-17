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

    public ArrayList<Option> getOptions(Student student){
        return new ArrayList<Option>();
    }

    private boolean validateBarnameh(Barnameh barnameh, History history){
        for(BarnamehPolicyChecker rule : barnamehRules)
            if(!rule.satisfy(barnameh))
                return false;

        for(StudentPolicyChecker rule : studentRules)
            if(!rule.satisfy(barnameh, history))
                return false;

        return true;
    }

    public boolean Register(Barnameh barnameh, History history){
        if(validateBarnameh(barnameh, history)) {
            // to be Registered
            return true;
        }
        return false;
    }

}
