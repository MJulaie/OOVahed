import javax.print.DocFlavor;
import java.util.*;

/**
 * Created by Ali on 5/18/2017 AD.
 */
public class Gerayesh {
    private String name;
    private String reshtehName;
    private Map<Integer, Chart> mappedCharts = new TreeMap<Integer, Chart>(Collections.reverseOrder());


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

    public void addChart(Chart newChart, Integer currentYear){
        mappedCharts.put(currentYear, newChart);
    }

    public Chart getChartByEnterance(Integer enterance){


        Set yearSet = mappedCharts.entrySet();
        Iterator year = yearSet.iterator();

        Map.Entry<Integer, Chart> entry = (Map.Entry<Integer, Chart>) year.next();
        while(year.hasNext()){
            entry = (Map.Entry<Integer, Chart>) year.next();

            if (entry.getKey() > enterance){
                continue;
            }
            break;
        }

        return entry.getValue();
    }


}
