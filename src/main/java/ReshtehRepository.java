import java.util.ArrayList;

/**
 * Created by Ali on 5/18/2017 AD.
 */
public class ReshtehRepository {
    private ArrayList<Reshteh> reshtehHa = new ArrayList<Reshteh>();
    private static ReshtehRepository instance = new ReshtehRepository();

    public static ReshtehRepository getInstance(){
        return instance;
    }

    private NormalChart initNormalChart(){
        CourseRepository courseRepo = CourseRepository.getInstance();
        NormalChart ghodratChart = new NormalChart();

        Course course1 = courseRepo.getCourseByName("a");
        ghodratChart.addCourse(course1);
        Course course2 = courseRepo.getCourseByName("b");
        ghodratChart.addCourse(course2);
        Course course3 = courseRepo.getCourseByName("c");
        ghodratChart.addCourse(course3);
        Course course4 = courseRepo.getCourseByName("d");
        ghodratChart.addCourse(course4);
        Course course5 = courseRepo.getCourseByName("e");
        ghodratChart.addCourse(course5);
        Course course6 = courseRepo.getCourseByName("f");
        ghodratChart.addCourse(course6);
        Course course7 = courseRepo.getCourseByName("g");
        ghodratChart.addCourse(course7);

        Course course8 = courseRepo.getCourseByName("h");
        ghodratChart.addOptionalCourses(course8);
        Course course9 = courseRepo.getCourseByName("i");
        ghodratChart.addOptionalCourses(course9);
        Course course10 = courseRepo.getCourseByName("j");
        ghodratChart.addOptionalCourses(course10);


        return ghodratChart;
    }

    private MinorChart initMinorChart(){
        CourseRepository courseRepo = CourseRepository.getInstance();
        MinorChart minorChart = new MinorChart();


        Course course1 = courseRepo.getCourseByName("l");
        minorChart.addNormalCourse(course1);
        Course course2 = courseRepo.getCourseByName("m");
        minorChart.addNormalCourse(course2);
        Course course3 = courseRepo.getCourseByName("g");
        minorChart.addNormalCourse(course3);

        Course course4 = courseRepo.getCourseByName("n");
        Course course5 = courseRepo.getCourseByName("o");
        ArrayList<Course> branchCourses1 = new ArrayList<Course>();
        branchCourses1.add(course4);
        branchCourses1.add(course5);
        minorChart.addBranchCourses(branchCourses1);

        Course course6 = courseRepo.getCourseByName("p");
        Course course7 = courseRepo.getCourseByName("q");
        ArrayList<Course> branchCourses2 = new ArrayList<Course>();
        branchCourses2.add(course6);
        branchCourses2.add(course7);
        minorChart.addBranchCourses(branchCourses2);



        return minorChart;
    }

    private ReshtehRepository() {

        Reshteh bargh = new Reshteh("Bargh");
        Reshteh fizik = new Reshteh("Fizik");
        NormalChart ghodratChart = initNormalChart();
        MinorChart fizikMinorChart = initMinorChart();

        Gerayesh ghodrat = new Gerayesh("ghodrat");
        Gerayesh mokhaberat = new Gerayesh("mokhaberat");
        ghodrat.addChart(ghodratChart, 1396);

        bargh.addGerayesh(ghodrat);
        bargh.addGerayesh(mokhaberat);

        Minor fizikMinor = new Minor(fizik, fizikMinorChart, 12);
        fizik.addMinor(bargh, fizikMinor);

        this.addReshteh(bargh);
        this.addReshteh(fizik);
    }


    public void addReshteh(Reshteh newReshteh){
        reshtehHa.add(newReshteh);
    }

    public Gerayesh getGerayeshByName(String gerayeshName){
        for (Reshteh reshteh : reshtehHa){
            if (reshteh.hasGerayesh(gerayeshName)){
                return reshteh.getGerayeshByName(gerayeshName);
            }
        }
        return null;
    }

    public Reshteh getReshtehByName(String reshtehName){
        for (Reshteh reshteh : reshtehHa){
            if (reshteh.getName().equals(reshtehName)){
                return reshteh;
            }
        }
        return null;
    }

    public Minor getMinorByReshteh(Reshteh sourceReshteh, Reshteh destinationReshteh){
        for (Reshteh reshteh : reshtehHa){
            if (reshteh.equals(sourceReshteh)){
                return reshteh.getMinorForReshteh(destinationReshteh);
            }
        }
        return null;
    }
}
