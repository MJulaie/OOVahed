import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ali on 5/18/2017 AD.
 */
public class Reshteh {
    private String name;
    private Map<Reshteh, Minor> minors = new HashMap<Reshteh, Minor>();
    private ArrayList<Gerayesh> gerayeshHa = new ArrayList<Gerayesh>();

    public Reshteh(String name) {
        Gerayesh defaultGerayesh = new Gerayesh("default");
        defaultGerayesh.setReshtehName(name);
        this.name = name;
        this.gerayeshHa.add(defaultGerayesh);
    }

    public void addGerayesh(Gerayesh gerayesh) {
        gerayesh.setReshtehName(name);
        this.gerayeshHa.add(gerayesh);
    }

    public String getName(){
        return this.name;
    }
    public boolean equals(Reshteh reshteh) {
        return this.name.equals(reshteh.name);
    }

    public void addMinor(Reshteh destReshteh, Minor minor){
        this.minors.put(destReshteh, minor);
    }

    public Minor getMinorForReshteh(Reshteh destReshteh){
        return minors.get(destReshteh);
    }

    public boolean hasGerayesh(String gerayeshName){
        for (Gerayesh gerayesh : gerayeshHa) {
            if (gerayesh.getName().equals(gerayeshName)) {
                return true;
            }
        }
        return false;
    }

    public Gerayesh getGerayeshByName(String gerayeshName) {
        for (Gerayesh gerayesh : gerayeshHa) {
            if (gerayesh.getName().equals(gerayeshName)) {
                return gerayesh;
            }
        }
        return null;
    }
}
