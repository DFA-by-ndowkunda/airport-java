package airport;

import java.lang.*;
import java.util.*;

public class Airport {
    List<String> hangarList;
    int maxCapacity;

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

    public Boolean isPlaneLanded(String name) {
        return this.hangarList.contains(name);
    }

    public String land(String name, Weather weather) {
        if (weather.isStorm()) {
            return String.format("%s cannot land yet, poor weather", name);
        }
        if (isFull() & !isPlaneLanded(name)) {
            return String.format("%s cannot land, airport full", name);
        }
        if (isPlaneLanded(name)) {
            return String.format("%s has already landed", name);
        } else {
            hangarList.add(name);
            return String.format("%s has landed", name);
         }
    }

    public String takeOff(String name, Weather weather) {
        if (weather.isStorm()) {
            return String.format("%s cannot land yet, poor weather", name);
        }
        if (isPlaneLanded(name)) {
            hangarList.remove(name);
            return String.format("%s has left airport", name);
        } else {
            return String.format("%s not at airport", name);
        }
    }
}