/**
 * Created by mohammad on 5/19/17.
 */
public class CapacityChecker extends BarnamehPolicyChecker {

    @Override
    public boolean satisfy(Barnameh barnameh) {

        for(Option option : barnameh.getOptions()){
            if(!option.haveCapacity())
                return false;
        }

        return true;
    }
}
