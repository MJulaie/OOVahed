/**
 * Created by mohammad on 5/17/17.
 */
public class Course {
    private String name;
    private int vahedNumber;
    private int courseID;

    public Course(String name, int vahedNumber, int courseID) {
        this.name = name;
        this.vahedNumber = vahedNumber;
        this.courseID = courseID;
    }

    public int getCourseID() {
        return courseID;
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

    @Override
    public String toString() {
        return name + " | vahedNumber : " + vahedNumber;
    }
}
