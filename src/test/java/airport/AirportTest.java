package airport;

import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

public class AirportTest {
    Airport gatwick;
    Plane mockPlane;
    Plane mockPlane2;
    Plane mockPlane3;
    Plane mockPlane4;
    Plane mockPlane5;
    Weather mockWeather;
    @BeforeEach
    public void setUp() {
         mockPlane = Mockito.spy(new Plane("airbusA320"));
         mockPlane2 = Mockito.spy(new Plane("airbusA321"));
         gatwick = new Airport(1);
         mockWeather =  mock(Weather.class);
         when(mockWeather.isStorm()).thenReturn(false);
    }

    @Test
    public void defaultCapacityReached() {
        gatwick.land(mockPlane.name,mockWeather);
        gatwick.land(mockPlane2.name,mockWeather);
        when(mockWeather.isStorm()).thenReturn(false);
        Assertions.assertEquals(1,gatwick.countHangar());
    }

    @Test
    public void defaultCapacityAltered() {
        gatwick.maxCapacity = 2;
        gatwick.land(mockPlane.name,mockWeather);
        gatwick.land(mockPlane2.name,mockWeather);
        when(mockWeather.isStorm()).thenReturn(false);
        Assertions.assertEquals(2,gatwick.countHangar());
    }

    @Test
    public void landPlane() {
        when(mockWeather.isStorm()).thenReturn(false);
        Assertions.assertEquals("airbusA320 has landed",gatwick.land(mockPlane.name,mockWeather));
    }

    @Test
    public void landTwiceError()  {
        gatwick.land(mockPlane.name,mockWeather);
        when(mockWeather.isStorm()).thenReturn(false);
        Assertions.assertEquals("airbusA320 has already landed", gatwick.land(mockPlane.name,mockWeather));
    }

    @Test
    public void landCapacityReachedError()  {
        gatwick.land(mockPlane.name,mockWeather);
        when(mockWeather.isStorm()).thenReturn(false);
        Assertions.assertEquals("airbusA321 cannot land, airport full", gatwick.land(mockPlane2.name,mockWeather));
    }

    @Test
    public void takeOff() {
        gatwick.land(mockPlane.name,mockWeather);
        when(mockWeather.isStorm()).thenReturn(false);
        Assertions.assertEquals("airbusA320 has left airport",gatwick.takeOff(mockPlane.name,mockWeather));
    }

    @Test
    public void takeOffTwiceError() {
        gatwick.land(mockPlane.name,mockWeather);
        gatwick.takeOff(mockPlane.name,mockWeather);

        Assertions.assertEquals("airbusA320 not at airport",gatwick.takeOff(mockPlane.name,mockWeather));
    }
    @Test
    public void landStormyWeatherError() {
        when(mockWeather.isStorm()).thenReturn(true);
        Assertions.assertEquals("airbusA320 cannot land yet, poor weather",gatwick.land(mockPlane.name,mockWeather));
    }
    @Test
    public void takeOffStormyWeatherError() {
        when(mockWeather.isStorm()).thenReturn(true);
        Assertions.assertEquals("airbusA320 cannot land yet, poor weather",gatwick.takeOff(mockPlane.name,mockWeather));
    }
    @Test
    void countPlanesInHangar() {
        mockPlane3 = Mockito.spy(new Plane("airbusA322"));
        mockPlane4 = Mockito.spy(new Plane("airbusA323"));
        mockPlane5 = Mockito.spy(new Plane("airbusA324"));
        gatwick.maxCapacity = 5;
        gatwick.land(mockPlane.name,mockWeather);
        gatwick.land(mockPlane2.name,mockWeather);
        gatwick.land(mockPlane3.name,mockWeather);
        gatwick.land(mockPlane4.name,mockWeather);
        gatwick.land(mockPlane5.name,mockWeather);
        Assertions.assertEquals(5, gatwick.countHangar());
    }
}
