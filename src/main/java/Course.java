/**
 * Created by mohammad on 5/17/17.
 */
public class Course {
    private String name;
    private int vahedNumber;

    public Course(String name, int vahedNumber) {
        this.name = name;
        this.vahedNumber = vahedNumber;
    }

    public int getVahedNumber() {
        return vahedNumber;
    }

    public String getName() {
        return name;
    }



    public boolean equals(Course course) {
        return course.getName().equals(name);
    }
}
