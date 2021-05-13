package airport;
import java.lang.*;
import java.util.*;

public class Airport {
    Plane plane;
    List<Plane> hangarList;

    public String land(Plane plane){
        List<Plane> hangarList = new ArrayList<>();
        hangarList.add(plane);
        return String.format("%s has landed",plane.name);
    }
}
