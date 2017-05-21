import javafx.collections.transformation.SortedList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;

/**
 * Created by mohammad on 5/17/17.
 */
public class History {
    private ArrayList<Barnameh> semesters = new ArrayList<Barnameh>();


    public float calculateLastSemesterRate(){

        Collections.sort(semesters);

        for (int i = semesters.size() - 1; i >= 0; i--){
            if (semesters.get(i).isActive()) {
                continue;
            }
            Barnameh lastBarnameh = semesters.get(i);
            return lastBarnameh.calculateRate();
        }

        return -1;
    }

    public ArrayList<Course> getPassedCourses(){
        ArrayList<Course> passedCourses = new ArrayList<Course>();
        for (Barnameh barnameh : semesters){
            passedCourses.addAll(barnameh.getPassedCourse());
        }
        return passedCourses;
    }

    public void addBarnameh(Barnameh newBarnameh){
        semesters.add(newBarnameh);
    }

    public Barnameh getActiveBarnameh(){

        for (Barnameh barnameh : semesters){
            if (barnameh.isActive()){
                return barnameh;
            }
        }
        return new Barnameh();
    }
}
