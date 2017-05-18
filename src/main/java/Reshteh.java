import java.util.ArrayList;

/**
 * Created by Ali on 5/18/2017 AD.
 */
public class Reshteh {
    private String name;
    private ArrayList<Gerayesh> gerayeshHa;

    public Reshteh(String name) {
        Gerayesh defaultGerayesh = new Gerayesh("default");
        defaultGerayesh.setReshtehName(name);
        this.gerayeshHa.add(defaultGerayesh);
    }

    public void addGerayesh(Gerayesh gerayesh) {
        gerayesh.setReshtehName(name);
        this.gerayeshHa.add(gerayesh);
    }
}
