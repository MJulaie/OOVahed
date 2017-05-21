/**
 * Created by Ali on 5/17/2017 AD.
 */
public class VahedNumberChecker extends StudentPolicyChecker {

    private final static int MAXIMUM_FOR_MASHROOT = 14;
    private final static int MINIMUM_FOR_AADI = 12;
    private final static int MINIMUM_FOR_MEHMAAN = 0;
    private final static int MAXIMUM_FOR_NOKHBEH = 24 ;
    private final static int MAXIMUM_FOR_OTHER = 20 ;

    private final static int NOKHBEH_RATE = 17;
    private final static int MASHROOT_RATE = 12;


    @Override
    public boolean satisfy(Barnameh barnameh, StudentState studentState, History history) {


        int vahedNumber = barnameh.getVahedNumber();
        float lastRate = history.calculateLastSemesterRate();
        boolean mashroot;
        boolean nokhbeh;
        boolean newStudent = (lastRate == -1) ? true : false;

        if (lastRate < MASHROOT_RATE && !newStudent) {
            mashroot = true;
        } else {
            mashroot = false;
        }

        if (lastRate > NOKHBEH_RATE){
            nokhbeh = true;
        } else {
            nokhbeh = false;
        }

        switch (studentState) {
            case MEHMAAN:
                if (vahedNumber > MINIMUM_FOR_MEHMAAN && vahedNumber <= MAXIMUM_FOR_OTHER ) {
                    return true;
                }
                break;
            case AADI:
                if (nokhbeh){
                    if (vahedNumber >= MINIMUM_FOR_AADI && vahedNumber <= MAXIMUM_FOR_NOKHBEH ){
                        return true;
                    }
                }
                else if (mashroot){
                    if (vahedNumber >= MINIMUM_FOR_AADI && vahedNumber <= MAXIMUM_FOR_MASHROOT ){
                        return true;
                    }
                }
                else {
                    if (vahedNumber >= MINIMUM_FOR_AADI && vahedNumber <= MAXIMUM_FOR_OTHER ){
                        return true;
                    } else {
                        System.out.println("|||");
                        System.out.println("minimum or maximum vahed number not satisfied, try again :(");
                        System.out.println("|||");

                    }
                }
                break;

        }
        return false;
    }
}
