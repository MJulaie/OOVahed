import java.util.ArrayList;

/**
 * Created by mohammad on 5/17/17.
 */
public class Barnameh {

    ArrayList<Option> optionlist = new ArrayList<Option>();

    public void addOption(Option selected){
        if(!optionlist.contains(selected))
            optionlist.add(selected);
        else
            System.out.println("You have Already Added this option!");
    }

    public void removeOption(Option selected){
        if(optionlist.contains(selected))
            optionlist.remove(selected);
    }
}
