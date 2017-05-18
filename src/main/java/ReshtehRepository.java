import java.util.ArrayList;

/**
 * Created by Ali on 5/18/2017 AD.
 */
public class ReshtehRepository {
    private ArrayList<Reshteh> reshtehHa;
    private static ReshtehRepository instance = new ReshtehRepository();

    public static ReshtehRepository getInstance(){
        return instance;
    }

    private Chart initChart(){
        CourseRepository courseRepo = CourseRepository.getInstance();
        Chart ghodratChart = new Chart();

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
        ghodratChart.addCourse(course8);

        return ghodratChart;
    }

    private ReshtehRepository() {

        Reshteh bargh = new Reshteh("Bargh");
        Chart ghodratChart = initChart();

        Gerayesh ghodrat = new Gerayesh("ghodrat");
        Gerayesh mokhaberat = new Gerayesh("mokhaberat");

        ghodrat.addChart(ghodratChart, 1396);

        bargh.addGerayesh(ghodrat);
        bargh.addGerayesh(mokhaberat);


        ReshtehRepository.getInstance().addReshteh(bargh);


        Reshteh naft = new Reshteh("naft");
        ReshtehRepository.getInstance().addReshteh(naft);
        Reshteh metal = new Reshteh("metal");
        ReshtehRepository.getInstance().addReshteh(metal);
    }


    public void addReshteh(Reshteh newReshteh){
        reshtehHa.add(newReshteh);
    }





}
