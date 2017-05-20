import java.util.ArrayList;

/**
 * Created by Ali on 5/18/2017 AD.
 */
public class TeacherRepository {
    private ArrayList<Teacher> teachers = new ArrayList<Teacher>();
    private static TeacherRepository instance = new TeacherRepository();

    public static TeacherRepository getInstance(){
        return instance;
    }

    private TeacherRepository() {

        Teacher teacher1 = new Teacher("ali","karimi", 1390, 91919);
        Teacher teacher2 = new Teacher("mohammad","julayi", 1370, 91842);
        Teacher teacher3 = new Teacher("ramtin","khosravi", 1380, 19042);


        teachers.add(teacher1);
        teachers.add(teacher2);
        teachers.add(teacher3);

    }

    public Teacher getTeacherByID(Integer nationalID){
        for (Teacher teacher : teachers){
            if (teacher.getNationalID().equals(nationalID)){
                return teacher;
            }
        }
        return null;
    }
}
