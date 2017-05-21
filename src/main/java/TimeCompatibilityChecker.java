import java.util.ArrayList;
import java.util.Set;

/**
 * Created by mohammad on 5/19/17.
 */
public class TimeCompatibilityChecker extends BarnamehPolicyChecker {

    @Override
    public boolean satisfy(Barnameh barnameh) {
        ArrayList<Option> optionList = barnameh.getOptions();

        boolean overlapp = false;
        for(int i = 0; i < optionList.size(); i++){
            for (int j = i + 1; j < optionList.size(); j++){

                if(!optionList.get(i).equals(optionList.get(j))){
                    if(optionList.get(i).hasOverlap(optionList.get(j))){
                        overlapp = true;
                        System.out.println("|||");
                        System.out.println("This two option have overlapp : ");
                        System.out.println(optionList.get(i));
                        System.out.println(optionList.get(j));
                        System.out.println("|||");
                    }

                }

            }

        }

        if (overlapp)
            return false;
        else
            return true;
    }
}
