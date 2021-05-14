package airport;

import org.junit.Test;
import org.junit.Assert;

public class AirportTest {
    @Test
    public void testlandPlane() {
        Plane plane = new Plane("planeOne");
        Airport airportOne = new Airport(1);
        Assert.assertEquals(airportOne.land(plane),"planeOne has landed");
    }
    @Test
    public void testdefaultCapacity() {
        Plane plane = new Plane("planeOne");
        Plane planeTwo = new Plane("planeTwo");
        Plane planeThree = new Plane("planeThree");
        Airport airportTwo = new Airport(2);
        airportTwo.land(plane);
        airportTwo.land(planeTwo);
        airportTwo.land(planeThree);
        Assert.assertEquals(airportTwo.land(planeThree),"planeThree cannot land, airport full");
    }
    @Test
    public void testPlaneTakeOff() {
        Plane plane = new Plane("planeOne");
        Airport airportThree = new Airport(2);
        airportThree.land(plane);
        Assert.assertEquals(airportThree.takeOff(plane),"planeOne has left airport");
    }
    @Test
    public void testInavlidPlaneTakeOff() {
        Plane plane = new Plane("planeOne");
        Airport airportFour = new Airport(2);
        airportFour.takeOff(plane);
        Assert.assertEquals(airportFour.takeOff(plane),"sorry planeOne is not at airport");
    }
    @Test
    public void testInvalidLandPlane() {
        Plane plane = new Plane("planeOne");
        Airport airportFive = new Airport(3);
        airportFive.land(plane);
        Assert.assertEquals(airportFive.land(plane),"sorry planeOne has already landed");
    }
    @Test
    public void testLandPlaneAfterTakeOff() {
        Plane plane = new Plane("planeOne");
        Airport airportSix = new Airport(3);
        airportSix.land(plane);
        airportSix.takeOff(plane);
        Assert.assertEquals(airportSix.land(plane),"planeOne has landed");
    }
}
