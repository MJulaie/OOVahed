import java.util.ArrayList;

/**
 * Created by Ali on 5/18/2017 AD.
 */
public class StudentInfo {
    private Integer enterance;
    private Gerayesh gerayesh;
    private Minor minor = null;

    public StudentInfo(Integer enterance, Gerayesh gerayesh) {
        this.enterance = enterance;
        this.gerayesh = gerayesh;
    }

    public boolean hasMinor(){
        return minor != null;
    }

    public Integer getEnterance() {
        return enterance;
    }

    public Gerayesh getGerayesh() {
        return gerayesh;
    }

    public NormalChart getNormalChart(){
        return gerayesh.getChartByEnterance(this.enterance);
    }

    public MinorChart getMinorChart() { return minor.getMinorChart(); }

    public void setMinor(Minor minor){
        this.minor = minor;
    }

    public ArrayList<Course> getRemainCourse(ArrayList<Course> passedCourses){
        return this.getNormalChart().getRemainCourses(passedCourses);
    }
}
