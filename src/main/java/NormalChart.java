import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mohammad on 5/17/17.
 */
public class NormalChart  {

    private ArrayList<Course> courses = new ArrayList<Course>();
    private Map<Course, ArrayList<Course>> Prerequisites = new HashMap<Course, ArrayList<Course>>();
    private ArrayList<Course> optionalCourses;
    private Map<ArrayList<Course>,Integer> groupCourses;
    private Integer minimumOptionalCourse = 10;


    public void addCourse(Course newCourse){
        courses.add(newCourse);
    }

    private boolean isEnoughOptionalCoursePassed(ArrayList<Course> passedOptionalCourses){
        Integer vahedNumber = 0;

        for (Course passedCourse : passedOptionalCourses){
            vahedNumber += passedCourse.getVahedNumber();
        }

        if (vahedNumber >= minimumOptionalCourse)
            return true;
        else
            return false;
    }

    private ArrayList<Course> deleteDuplicateFromFirst(ArrayList<Course> firstList, ArrayList<Course> secondList){
        for (Course course : firstList){
            if (secondList.contains(course))
                firstList.remove(course);
        }

        return firstList;
    }
    private ArrayList<Course> getPassedOptionalCourses(ArrayList<Course> passedCourses){
        ArrayList<Course> passedOptionalCourses = new ArrayList<Course>();

        for (Course course : optionalCourses){
            if (passedCourses.contains(course)){
                passedOptionalCourses.add(course);
            }
        }
        return passedOptionalCourses;
    }

    public void addOptionalCourses(Course optionalCourse){
        this.courses.add(optionalCourse);
        this.optionalCourses.add(optionalCourse);
    }

    public void addCourseWithPrerequisite(Course course, Course prerequisite){
        if(Prerequisites.containsKey(course)){
            Prerequisites.get(course).add(prerequisite);
        } else {
            ArrayList<Course> newCourseList = new ArrayList<Course>();
            newCourseList.add(prerequisite);
            Prerequisites.put(course, newCourseList);
        }
    }

    private ArrayList<Course> getDistinctOptionalCourses(ArrayList<Course> passedCourses, ArrayList<Course> minorGraduateCourses){
        ArrayList<Course> passedOptionalCourses = this.getPassedOptionalCourses(passedCourses);
        return this.deleteDuplicateFromFirst(passedOptionalCourses, minorGraduateCourses);
    }

    public ArrayList<Course> getRemainOptionalCourse(ArrayList<Course> passedCourses){
        return this.deleteDuplicateFromFirst(this.optionalCourses, passedCourses);
    }

    public ArrayList<Course> getRemainOptionalCourse(ArrayList<Course> passedCourse, ArrayList<Course> minorGraduateCourses){
        ArrayList<Course> distinctPassedOptionalCourses = this.getDistinctOptionalCourses(passedCourse, minorGraduateCourses);
        return this.deleteDuplicateFromFirst(this.optionalCourses, distinctPassedOptionalCourses);
    }


    public boolean isGraduateWithMinor(ArrayList<Course> passedCourses, ArrayList<Course> minorGraduateCourses){
        ArrayList<Course> distinctPassedOptionalCourses = this.getDistinctOptionalCourses(passedCourses, minorGraduateCourses);
        if (this.isEnoughOptionalCoursePassed(distinctPassedOptionalCourses)){
            return this.isGraduateNormal(passedCourses);
        } else
            return false;

    }

    public boolean isGraduateNormal(ArrayList<Course> passedCourses){
        for (Course course : courses) {
            if (!passedCourses.contains(course)) {
                return false;
            }
        }

        ArrayList<Course> passedOptionalCourses = this.getPassedOptionalCourses(passedCourses);
        return this.isEnoughOptionalCoursePassed(passedOptionalCourses);
    }

    public ArrayList<Course> getRemainCourses(ArrayList<Course> passedCourses){
        ArrayList<Course> remainCourses = new ArrayList<Course>();

        for (Course course : courses) {
            if (!passedCourses.contains(course)) {
                remainCourses.add(course);
            }
        }
        return remainCourses;
    }

    public ArrayList<Course> getPrerequisities(Course course){

        if(Prerequisites.get(course) != null)
            return Prerequisites.get(course);
        else
            return new ArrayList<Course>();
    }

}
