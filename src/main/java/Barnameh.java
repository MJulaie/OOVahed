import org.joda.time.LocalDate;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by mohammad on 5/17/17.
 */
public class Barnameh implements Comparable<Barnameh> {

    private Map<Option, OptionState> optionList;
    private LocalDate startDate;
    private boolean active;

    public Barnameh() {
        this.optionList = new HashMap<Option, OptionState>();
        this.startDate = new LocalDate();
        this.active = true;
    }

    public Barnameh(ArrayList<Option> options){
        this.optionList = new HashMap<Option, OptionState>();

        for (Option option : options){
            optionList.put(option, new OptionState());
        }

        this.startDate = new LocalDate();
        this.active = true;
    }

    public void setActiveFlag(boolean activeFlag){
        this.active = activeFlag;
    }
    public void addOption(Option newOption, int grade, OptionLiveState state){
        optionList.put(newOption, new OptionState(grade, state));
    }
    public void addOption(Option selected){

        if(!optionList.containsKey(selected)) {
            optionList.put(selected, new OptionState());
        }
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

            Option passedOption = entry.getKey();
            OptionState passedOptionState = entry.getValue();

            if (passedOptionState.getState() == OptionLiveState.MARDOOD||
            passedOptionState.getState() == OptionLiveState.PASSSHODEH){
                allVahed += passedOption.getVahedNumber();
                result += passedOptionState.getScore() * passedOption.getVahedNumber();
            }
        }

        return result / allVahed;
    }

    public ArrayList<Course> getPassedCourse(){
        ArrayList<Course> passedCourses = new ArrayList<Course>();

        for (Map.Entry<Option, OptionState> entry : optionList.entrySet()){
            Option passedOption = entry.getKey();
            OptionState passedOptionState = entry.getValue();

            if (passedOptionState.isPassed()) {
                passedCourses.add(passedOption.getCourse());
            }
        }

        return passedCourses;
    }

    public boolean hasCourse(Course course){

        for(Option option : optionList.keySet()){
            if(option.getCourse().equals(course))
                return true;
        }

        return false;
    }

    public ArrayList<Course> getCourses(){

        ArrayList<Course> result = new ArrayList<Course>();

        for(Option option : optionList.keySet()){
            result.add(option.getCourse());
        }

        return result;
    }

    public ArrayList<Option> getOptions(){
        return new ArrayList<Option>(optionList.keySet());
    }

    public int compareTo(Barnameh barnameh) {

        if(startDate.isBefore(barnameh.startDate))
            return -1;
        else if(startDate.isAfter(barnameh.startDate))
            return 1;
        else
            return 0;

    }

    public boolean isActive(){
        return active;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Option option : optionList.keySet()){
            sb.append(option);
            sb.append('\n');
        }

        return sb.toString();
    }
}
