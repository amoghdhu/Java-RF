package CH1.Library;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private String name;
    private List<Rack> rackList;

    public Library(String name, List<Rack> rackList) {
        this.name = name;
        this.rackList = rackList;
    }

    public String getName() {
        return name;
    }

    public List<Rack> getRackList() {
        return rackList;
    }

    public boolean addRack(Rack rack){
        if(isExists(rack)){
            return false;
        }
        else {
            rackList.add(rack);
            return true;
        }
    }

    public boolean isExists(Rack rack){
        if(rackList.contains(rack)){
            return true;
        } else {
            return false;
        }
    }

    public int getSize(){
        return rackList.size();
    }

    @Override
    public String toString() {
        return "Library{" +
                "name='" + name + '\'' +
                ", rackList=" + rackList +
                '}';
    }
}
