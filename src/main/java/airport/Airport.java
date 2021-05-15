package airport;
import java.lang.*;
import java.util.*;

public class Airport {
    List<String> hangarList;
    int maxCapacity;
    Weather weather;

    Airport(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        this.hangarList = new ArrayList<>();
    }

    public int countHangar() {
        return this.hangarList.size();
    }

    public Boolean isFull() {
        return this.hangarList.size() >= maxCapacity;
    }

    public Boolean isLanded(String name) {
        return this.hangarList.contains(name);
    }

    public String land(String name, Weather weather) {
        if (!weather.isStorm()) {
        if (isFull() & !isLanded(name)) {
            return String.format("%s cannot land, airport full", name);
        }
        if (isLanded(name)) {
            return String.format("%s has already landed", name);
        } else {
            hangarList.add(name);
            return String.format("%s has landed", name);
         }
        }
        else{
            return String.format("%s cannot land yet, poor weather", name);
        }
    }

    public String takeOff(String name, Weather weather) {
        if (!weather.isStorm()) {
            if (isLanded(name)) {
                hangarList.remove(name);
                return String.format("%s has left airport", name);
            } else {
                return String.format("%s not at airport", name);
            }
        } else{
            return String.format("%s cannot land yet, poor weather", name);
        }
    }
}