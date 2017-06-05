import java.util.ArrayList;

/**
 * Created by Ali on 6/3/2017 AD.
 */
public class MinorChart {

    private class MinorBranch {
        private ArrayList<Course> branchCourses;
        public MinorBranch(ArrayList<Course> branchCourses) {
            this.branchCourses = branchCourses;
        }

        public ArrayList<Course> getRemainCourses(ArrayList<Course> passedCourses){
            ArrayList<Course> remainCourses = new ArrayList<Course>();

            for (Course course : branchCourses) {
                if (!passedCourses.contains(course)) {
                    remainCourses.add(course);
                }

            }
            return remainCourses;
        }

        public boolean achieveMinorBranch(ArrayList<Course> passedCourses){

            for (Course course : branchCourses) {
                if (!passedCourses.contains(course)) {
                    return false;
                }
            }
            return true;
        }

        public ArrayList<Course> getBranchCourses() {
            return branchCourses;
        }
    }

    private ArrayList<Course> mainCourses;
    private ArrayList<MinorBranch> branches;

    public void addNormalCourse(Course newCourse){
        mainCourses.add(newCourse);
    }

    public void addBranchCourses(ArrayList<Course> branchCourses){
        branches.add(new MinorBranch(branchCourses));
    }

    public ArrayList<Course> getGraduateCourses(ArrayList<Course> passedCourses){
        ArrayList<Course> graduateCourses = new ArrayList<Course>();
        graduateCourses.addAll(mainCourses);

        for (MinorBranch branch : branches){
            if (branch.achieveMinorBranch(passedCourses)){
                graduateCourses.addAll(branch.getBranchCourses());
                return graduateCourses;
            }
        }
        return null;
    }


    public boolean graduateMinorWithCourses(ArrayList<Course> passedCourses){

        for (Course course : mainCourses) {
            if (!passedCourses.contains(course)) {
                return false;
            }
        }

        for (MinorBranch branch : branches){
            if (branch.achieveMinorBranch(passedCourses))
                return true;
        }

        return false;
    }

    public ArrayList<Course> getRemainCourses(ArrayList<Course> passedCourses){
        ArrayList<Course> remainCourses = new ArrayList<Course>();

        for (Course course : mainCourses) {
            if (!passedCourses.contains(course)) {
                remainCourses.add(course);
            }

        }

        for (MinorBranch branch : branches){
            remainCourses.addAll(branch.getRemainCourses(passedCourses));
        }

        return remainCourses;
    }
}
