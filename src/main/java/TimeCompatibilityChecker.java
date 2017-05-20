import java.util.ArrayList;
import java.util.Set;

/**
 * Created by mohammad on 5/19/17.
 */
public class TimeCompatibilityChecker extends BarnamehPolicyChecker {

    @Override
    public boolean satisfy(Barnameh barnameh) {
        Set<Option> optionSet = barnameh.getOptions();

        for(Option option1 : optionSet)
            for (Option option2 : optionSet)
                if(!option1.equals(option2))
                    if(option1.hasOverlap(option2))
                        return false;

        return true;
    }
}
