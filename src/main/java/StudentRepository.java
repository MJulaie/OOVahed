import java.util.ArrayList;

/**
 * Created by Ali on 5/20/2017 AD.
 */
public class StudentRepository {
    private ArrayList<Student> students = new ArrayList<Student>();
    private static StudentRepository instance = new StudentRepository();

    public static StudentRepository getInstance(){
        return instance;
    }

    private StudentRepository(){
        ReshtehRepository reshtehRepository = ReshtehRepository.getInstance();
        OptionRepository optionRepository = OptionRepository.getInstance();

        Barnameh newBarnameh1 = new Barnameh();
        newBarnameh1.setActiveFlag(false);
        newBarnameh1.addOption(optionRepository.getOptionByID(1), 13, OptionLiveState.PASSSHODEH);
        newBarnameh1.addOption(optionRepository.getOptionByID(3), 15, OptionLiveState.PASSSHODEH);
        newBarnameh1.addOption(optionRepository.getOptionByID(4), 16, OptionLiveState.PASSSHODEH);
        newBarnameh1.addOption(optionRepository.getOptionByID(5), 14, OptionLiveState.PASSSHODEH);

        Barnameh newBarnameh2 = new Barnameh();
        newBarnameh2.setActiveFlag(false);
        newBarnameh2.addOption(optionRepository.getOptionByID(7), 19, OptionLiveState.PASSSHODEH);
        newBarnameh2.addOption(optionRepository.getOptionByID(8), 20, OptionLiveState.PASSSHODEH);
//        newBarnameh2.addOption(optionRepository.getOptionByID(9), 18, OptionLiveState.PASSSHODEH);



        Gerayesh gerayesh1 = reshtehRepository.getGerayeshByName("ghodrat");

        Reshteh bargh = reshtehRepository.getReshtehByName("Bargh");
        Reshteh fizik = reshtehRepository.getReshtehByName("Fizik");

        Minor minor = reshtehRepository.getMinorByReshteh(fizik, bargh);

        Student student1 = new Student("kazem", "akbari", 9012901, 810192456, gerayesh1, 1392);
        Student student2 = new Student("nasim", "rajavi", 9030103, 810192391, gerayesh1, 1392);

        student1.setMinor(minor);

        student2.addBarnameh(newBarnameh1);
        student2.addBarnameh(newBarnameh2);

        students.add(student1);
        students.add(student2);
    }

    public Student getStudentByStudentNumber(Integer studentNumber) {
        for (Student student : students) {
            if (student.getStudentNumber().equals(studentNumber)) {
                return student;
            }
        }
        return null;
    }

}
