/**
 * Created by mohammad on 5/19/17.
 */
public class CapacityChecker extends BarnamehPolicyChecker {

    @Override
    public boolean satisfy(Barnameh barnameh) {

        boolean hasNotCapacity = false;
        for(Option option : barnameh.getOptions()){
            if(!option.haveCapacity()){
                hasNotCapacity = true;
                System.out.println("this option : " + option + " has not capacity for you :( try again later!");
            }
        }

        if (hasNotCapacity)
            return false;
        else
            return true;
    }
}
