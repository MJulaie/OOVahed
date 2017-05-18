import java.util.ArrayList;

/**
 * Created by mohammad on 5/17/17.
 */
public class VahedProcess {

    private Barnameh barnameh = new Barnameh();
    private VahedSelectionService Amoozesh;
    private Student student;
    private ArrayList<Option> options = new ArrayList<Option>();

    public VahedProcess(Student student) {
        this.student = student;
        this.Amoozesh = student.getAmoozesh().getVahedSelectionService();
        this.options = Amoozesh.getOptions(student.getStudentInfo(), student.getHistory());
    }

    public void addOption(int i){
        barnameh.addOption(options.get(i));
    }

    public void removeOption(int i){
        barnameh.removeOption(options.get(i));
    }

    public void confirm(){
        if(Amoozesh.Register(barnameh, student.getStudentState(), student.getHistory())) {
            return;
        }
    }

}
