import java.util.ArrayList;
import java.util.Set;

/**
 * Created by mohammad on 5/17/17.
 */
public class VahedProcess {

    private Barnameh barnameh;
    private VahedSelectionService Amoozesh;
    private Student student;
    private ArrayList<Option> temporarySelectedOptions = new ArrayList<Option>();
    private ArrayList<Option> options = new ArrayList<Option>();

    public VahedProcess(Student student) {
        this.barnameh = student.getHistory().getActiveBarnameh();
        this.student = student;
        this.Amoozesh = student.getAmoozesh().getVahedSelectionService();
        this.options = Amoozesh.getOptions(student.getStudentInfo(), student.getHistory());
    }

    public void printOptions() {
        int i = 0;
        for (Option option : options) {
            i++;
            System.out.println(i + " : " + option);
        }
    }


    public void printCurrentBarnameh() {
        System.out.println(this.barnameh);

        for (Option option : temporarySelectedOptions){
            System.out.println(option);

        }
        System.out.println();
    }

    public void addOption(int i) {
        Option selected = options.get(i - 1);
        temporarySelectedOptions.add(selected);
        selected.decreaseCapacity();
    }

    public void removeOption(int i) {
        Option selected = options.get(i - 1);
        temporarySelectedOptions.remove(selected);
        selected.increaseCapacity();
    }

    public void reverseCapacity() {
        for (Option option : temporarySelectedOptions) {
            option.increaseCapacity();
        }

    }

    public boolean validateBarnameh() {
        ArrayList<Option> tempOptions = barnameh.getOptions();
        tempOptions.addAll(temporarySelectedOptions);
        Barnameh tempBarnameh = new Barnameh(tempOptions);
        return Amoozesh.validateBarnameh(tempBarnameh, student.getStudentState(), student.getHistory());
    }

    public void confirmBarnameh() {
        ArrayList<Option> tempOptions = barnameh.getOptions();
        tempOptions.addAll(temporarySelectedOptions);
        Barnameh tempBarnameh = new Barnameh(tempOptions);
        if (Amoozesh.Register(tempBarnameh, student.getStudentState(), student.getHistory())){
            temporarySelectedOptions.clear();
            barnameh = tempBarnameh;
        }
        return;
    }
}