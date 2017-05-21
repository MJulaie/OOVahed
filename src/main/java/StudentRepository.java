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

        Gerayesh gerayesh1 = reshtehRepository.getGerayeshByName("ghodrat");
        Gerayesh gerayesh2 = reshtehRepository.getGerayeshByName("mokhaberat");

        Student student1 = new Student("kazem", "akbari", 9012901, 810192456, gerayesh1, 1392);
        Student student2 = new Student("nasim", "rajavi", 9030103, 810192391, gerayesh1, 1392);

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
