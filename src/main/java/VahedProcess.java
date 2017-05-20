import java.util.ArrayList;

/**
 * Created by mohammad on 5/17/17.
 */
public class VahedProcess {

    private Barnameh barnameh;
    private VahedSelectionService Amoozesh;
    private Student student;
    private ArrayList<Option> options = new ArrayList<Option>();

    public VahedProcess(Student student) {
        this.barnameh = student.getHistory().getActiveBarnameh();
        this.student = student;
        this.Amoozesh = student.getAmoozesh().getVahedSelectionService();
        this.options = Amoozesh.getOptions(student.getStudentInfo(), student.getHistory());
    }

    public void printOptions(){
        int i = 0;
        for (Option option : options){
            i++;
            System.out.println(i + " : " + option);
        }
    }


    public void printCurrentBarnameh(){
        System.out.println(this.barnameh);
    }

    public void addOption(int i){
        barnameh.addOption(options.get(i - 1));
    }

    public void removeOption(int i){
        barnameh.removeOption(options.get(i - 1));
    }


    public boolean validateBarnameh(){
        return Amoozesh.validateBarnameh(barnameh,student.getStudentState(), student.getHistory());
    }
    public void confirmBarnameh(){
        if(Amoozesh.Register(barnameh, student.getStudentState(), student.getHistory())) {
            return;
        }
    }

}
