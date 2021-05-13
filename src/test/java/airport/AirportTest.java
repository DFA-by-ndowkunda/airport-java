package airport;

import org.junit.Test;
import org.junit.Assert;

public class AirportTest {
    @Test
     public void testlandPlane() {
        Plane plane = new Plane("planeOne");
        Airport airportOne = new Airport();
        Assert.assertEquals(airportOne.land(plane),"planeOne has landed");
    }
}