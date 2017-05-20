import org.joda.time.LocalDate;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by mohammad on 5/17/17.
 */
public class Barnameh implements Comparable<Barnameh> {

    private Map<Option, OptionState> optionList;
    private ArrayList<String> temparray;
    private LocalDate startDate;

    public Barnameh() {
        this.optionList = new HashMap<Option, OptionState>();
        this.temparray = new ArrayList<String>();
        this.startDate = new LocalDate();
    }

    public void addOption(Option selected){

        if(!optionList.containsKey(selected)) {
            temparray.add("lskdj");
            System.out.println(temparray.size());
//
//            System.out.println("Your selected option : " + selected);
//            optionList.put(selected, new OptionState());
//            System.out.println(this.startDate);
//            System.out.println(this);
        }
        else
            System.out.println("You have Already Added this option!");
    }

    public void removeOption(Option selected){
        if(optionList.containsKey(selected))
            optionList.remove(selected);
    }

    public int getSize(){
        return temparray.size();
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

    public Set<Option> getOptions(){
        return optionList.keySet();
    }

    public int compareTo(Barnameh barnameh) {

        if(startDate.isBefore(barnameh.startDate))
            return -1;
        else if(startDate.isAfter(barnameh.startDate))
            return 1;
        else
            return 0;

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        System.out.println("size : " + optionList.size());
        for (Option option : optionList.keySet()){
            System.out.println("selected ! : " + option);
            sb.append(option);
            sb.append('\n');
        }

        return sb.toString();
    }
}
