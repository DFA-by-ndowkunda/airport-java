package airport;
import java.lang.*;
import java.util.*;

public class Airport {
    Plane plane;
    List<Plane> hangarList = new ArrayList<>();
    int maxCapacity;

    Airport(int maxCapacity){
        this.maxCapacity = maxCapacity;
    }

    public Boolean isFull(){
        return hangarList.size() > maxCapacity;
    }

    public String land(Plane plane){
        if(isFull()){
            return String.format("%s cannot land, airport full",plane.name);
        }
        if(plane.isLanded){
            return String.format("sorry %s has already landed",plane.name);
        }else{
            hangarList.add(plane);
            return String.format("%s has landed",plane.name);
        }

    }
    public String takeOff(Plane plane){
        if(hangarList.contains(plane)){
            hangarList.remove(plane);
            plane.isLanded = false;
            return String.format("%s has left airport",plane.name);
        }
        else {
            return String.format("sorry %s is not at airport",plane.name);
        }



        }

    }

