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
        Barnameh lastBarnameh = semesters.get(semesters.size() - 1);
        return lastBarnameh.calculateRate();

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
}
