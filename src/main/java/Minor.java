import java.util.ArrayList;

/**
 * Created by Ali on 6/3/2017 AD.
 */
public class Minor {
    private Reshteh sourceReshteh;
    private MinorChart minorChart;
    private Integer minimumStudentRate;


    public Minor(Reshteh sourceReshteh, MinorChart minorChart, Integer minimumStudentRate) {
        this.sourceReshteh = sourceReshteh;
        this.minorChart = minorChart;
        this.minimumStudentRate = minimumStudentRate;
    }

    public MinorChart getMinorChart(){
        return minorChart;
    }



}
