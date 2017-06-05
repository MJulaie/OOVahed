import javax.print.DocFlavor;
import java.util.*;

/**
 * Created by Ali on 5/18/2017 AD.
 */
public class Gerayesh {
    private String name;
    private Reshteh reshteh;
    private String reshtehName;
    private Map<Integer, NormalChart> mappedCharts = new TreeMap<Integer, NormalChart>(Collections.reverseOrder());


    public Gerayesh(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setReshtehName(String reshtehName) {
        this.reshtehName = reshtehName;
    }

    public String getName(){
        return name;
    }

    public void addChart(NormalChart newChart, Integer currentYear){
        mappedCharts.put(currentYear, newChart);
    }

    public NormalChart getChartByEnterance(Integer enterance){


        Set yearSet = mappedCharts.entrySet();
        Iterator year = yearSet.iterator();

        Map.Entry<Integer, NormalChart> entry = (Map.Entry<Integer, NormalChart>) year.next();
        Integer authorizedYear = entry.getKey();
        NormalChart authorizedChart = entry.getValue();

        while(year.hasNext()){
            entry = (Map.Entry<Integer, NormalChart>) year.next();
            authorizedYear = entry.getKey();
            authorizedChart = entry.getValue();

            if (authorizedYear > enterance){
                continue;
            }
            break;
        }

        return authorizedChart;
    }


}
