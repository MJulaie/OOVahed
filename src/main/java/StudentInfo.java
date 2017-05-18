import java.util.ArrayList;

/**
 * Created by Ali on 5/18/2017 AD.
 */
public class StudentInfo {
    private Integer enterance;
    private Gerayesh gerayesh;


    public StudentInfo(Integer enterance, Gerayesh gerayesh) {
        this.enterance = enterance;
        this.gerayesh = gerayesh;
    }

    public Integer getEnterance() {
        return enterance;
    }

    public Gerayesh getGerayesh() {
        return gerayesh;
    }

    public Chart getChart(){
        return gerayesh.getChartByEnterance(this.enterance);
    }

    public ArrayList<Course> getRemainCourse(ArrayList<Course> passedCourses){
        return this.getChart().getRemainCourses(passedCourses);
    }
}
