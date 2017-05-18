import java.util.ArrayList;

/**
 * Created by Ali on 5/18/2017 AD.
 */
public class TeacherRepository {
    private ArrayList<Teacher> teachers;
    private static TeacherRepository instance = new TeacherRepository();

    public static TeacherRepository getInstance(){
        return instance;
    }

    private TeacherRepository() {

        Teacher teacher1 = new Teacher("ali","karimi", 1390, 91919);
        Teacher teacher2 = new Teacher("mohammad","julayi", 1290, 91842);

        teachers.add(teacher1);
        teachers.add(teacher2);
    }

    public Teacher getTeacherByName(String teacherName, Integer nationalID){
        for (Teacher teacher : teachers){
//            if (teacher.getName().equals(teacherName)){
//                return teacher;
//            }
        }
        return null;
    }
}
