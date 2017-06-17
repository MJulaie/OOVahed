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
//        newBarnameh1.addOption(optionRepository.getOptionByID(5), 14, OptionLiveState.PASSSHODEH);
//        newBarnameh1.addOption(optionRepository.getOptionByID(6), 14, OptionLiveState.PASSSHODEH);
//        newBarnameh1.addOption(optionRepository.getOptionByID(10), 14, OptionLiveState.PASSSHODEH);

        Barnameh newBarnameh2 = new Barnameh();
        newBarnameh2.setActiveFlag(false);
        newBarnameh2.addOption(optionRepository.getOptionByID(8), 19, OptionLiveState.PASSSHODEH);
        newBarnameh2.addOption(optionRepository.getOptionByID(9), 20, OptionLiveState.PASSSHODEH);
//        newBarnameh2.addOption(optionRepository.getOptionByID(9), 18, OptionLiveState.PASSSHODEH);



        Barnameh newBarnameh3 = new Barnameh();
        newBarnameh3.setActiveFlag(false);
        newBarnameh3.addOption(optionRepository.getOptionByID(1),14,OptionLiveState.PASSSHODEH); //a
        newBarnameh3.addOption(optionRepository.getOptionByID(3),14,OptionLiveState.PASSSHODEH); //b
        newBarnameh3.addOption(optionRepository.getOptionByID(4),14,OptionLiveState.PASSSHODEH); //c
        newBarnameh3.addOption(optionRepository.getOptionByID(5),14,OptionLiveState.PASSSHODEH); //d
        newBarnameh3.addOption(optionRepository.getOptionByID(6),14,OptionLiveState.PASSSHODEH); //e
        newBarnameh3.addOption(optionRepository.getOptionByID(8),14,OptionLiveState.PASSSHODEH); //f
        newBarnameh3.addOption(optionRepository.getOptionByID(17),14,OptionLiveState.PASSSHODEH); //g
        newBarnameh3.addOption(optionRepository.getOptionByID(9),14,OptionLiveState.PASSSHODEH); //h


        Barnameh newBarnameh4 = new Barnameh();
        newBarnameh4.setActiveFlag(false);
        newBarnameh4.addOption(optionRepository.getOptionByID(10),14,OptionLiveState.PASSSHODEH); //i
        newBarnameh4.addOption(optionRepository.getOptionByID(13),14,OptionLiveState.PASSSHODEH); //l
        newBarnameh4.addOption(optionRepository.getOptionByID(14),14,OptionLiveState.PASSSHODEH); //m
        newBarnameh4.addOption(optionRepository.getOptionByID(15),14,OptionLiveState.PASSSHODEH); //n
        newBarnameh4.addOption(optionRepository.getOptionByID(16),14,OptionLiveState.PASSSHODEH); //o


        Barnameh newBarnameh5 = new Barnameh();
        newBarnameh5.setActiveFlag(false);
        newBarnameh5.addOption(optionRepository.getOptionByID(13), 14, OptionLiveState.PASSSHODEH);
        newBarnameh5.addOption(optionRepository.getOptionByID(14), 14, OptionLiveState.PASSSHODEH);
        newBarnameh5.addOption(optionRepository.getOptionByID(4), 14, OptionLiveState.PASSSHODEH);
        newBarnameh5.addOption(optionRepository.getOptionByID(5), 14, OptionLiveState.PASSSHODEH);

        Gerayesh gerayesh1 = reshtehRepository.getGerayeshByName("ghodrat");

        Reshteh bargh = reshtehRepository.getReshtehByName("Bargh");
        Reshteh fizik = reshtehRepository.getReshtehByName("Fizik");

        Minor minor = reshtehRepository.getMinorByReshteh(fizik, bargh);

        Student student1 = new Student("kazem", "akbari", 9012901, 810192456, gerayesh1, 1392);
        Student student2 = new Student("nasim", "rajavi", 9030103, 810192331, gerayesh1, 1392);
        Student student3 = new Student("ali", "karimiii", 9039041, 810192222, gerayesh1, 1392);


        student3.setMinor(minor);
        student3.addBarnameh(newBarnameh5);

        student1.setMinor(minor);
        student1.addBarnameh(newBarnameh3);
        student1.addBarnameh(newBarnameh4);

        student2.addBarnameh(newBarnameh1);
        student2.addBarnameh(newBarnameh2);

        students.add(student1);
        students.add(student2);
        students.add(student3);
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
