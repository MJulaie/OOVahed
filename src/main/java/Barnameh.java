import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by mohammad on 5/17/17.
 */
public class Barnameh {

    private Map<Option, OptionState> optionList = new HashMap<Option, OptionState>();
    private Date startDate;
//    ArrayList<Option> optionlist = new ArrayList<Option>();

    public Barnameh() {
        this.startDate = Calendar.getInstance().getTime();
    }

    public void addOption(Option selected){

        if(!optionList.containsKey(selected))
            optionList.put(selected, new OptionState());
        else
            System.out.println("You have Already Added this option!");
    }

    public void removeOption(Option selected){
        if(optionList.containsKey(selected))
            optionList.remove(selected);
    }

    public int getVahedNumber() {
        int result = 0;
        for (Option option: optionList.keySet()) {
            result += option.getVahedNumber();
        }

        return result;
    }

    public float calculateRate() {
        int allVahed = 0;
        int result = 0;


        for (Map.Entry<Option, OptionState> entry : optionList.entrySet()){
            if (entry.getValue().getState() == OptionLiveState.MARDOOD||
            entry.getValue().getState() == OptionLiveState.PASSSHODEH){
                allVahed += entry.getKey().getVahedNumber();
                result += entry.getValue().getScore() * entry.getKey().getVahedNumber();
            }
        }

        return result / allVahed;
    }

    public ArrayList<Course> getPassedCourse(){
        ArrayList<Course> passedCourses = new ArrayList<Course>();

        for (Map.Entry<Option, OptionState> entry : optionList.entrySet()){
            if (entry.getValue().isPassed()) {
                passedCourses.add(entry.getKey().getCourse());
            }
        }

        return passedCourses;
    }
}
