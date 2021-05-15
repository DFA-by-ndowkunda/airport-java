package airport;

import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

public class AirportTest {
    Airport gatwick;
    Plane mockPlane;
    Plane mockPlane2;
    Weather mockWeather;
    @BeforeEach
    public void setUp() {
         mockPlane = Mockito.spy(new Plane("airbusA320"));
         mockPlane2 = Mockito.spy(new Plane("airbusA321"));
         mockWeather =  mock(Weather.class);
         when(mockWeather.isStorm()).thenReturn(false);
         gatwick = new Airport(1);
    }
//Acceptance Criteria
    @Nested
    @DisplayName("Test Airport Capacity")
    class AirportCapacity {
        @Test
        public void defaultCapacityReached() {
            gatwick.land(mockPlane.name, mockWeather);
            gatwick.land(mockPlane2.name, mockWeather);
            Assertions.assertEquals(1, gatwick.countHangar());
        }

        @Test
        public void defaultCapacityAltered() {
            gatwick.maxCapacity = 2;
            gatwick.land(mockPlane.name, mockWeather);
            gatwick.land(mockPlane2.name, mockWeather);
            Assertions.assertEquals(2, gatwick.countHangar());
        }
    }
    @Nested
    @DisplayName("Test Plane Landings")
    class LandPlane {
        @Test
        public void successfulLanding() {
            Assertions.assertEquals("airbusA320 has landed", gatwick.land(mockPlane.name, mockWeather));
        }

        @Test
        public void preventSamePlaneLanding() {
            gatwick.land(mockPlane.name, mockWeather);
            Assertions.assertEquals("airbusA320 has already landed", gatwick.land(mockPlane.name, mockWeather));
        }

        @Test
        public void preventLandingInFullAirport() {
            gatwick.land(mockPlane.name, mockWeather);
            Assertions.assertEquals("airbusA321 cannot land, airport full", gatwick.land(mockPlane2.name, mockWeather));
        }
    }
    @Nested
    @DisplayName("Test Plane Take Offs")
    class TakeOff {
        @Test
        public void successfulTakeOff() {
            gatwick.land(mockPlane.name, mockWeather);
            Assertions.assertEquals("airbusA320 has left airport", gatwick.takeOff(mockPlane.name, mockWeather));
        }

        @Test
        public void preventTakeOffNotAtAirport() {
            gatwick.land(mockPlane.name, mockWeather);
            gatwick.takeOff(mockPlane.name, mockWeather);
            Assertions.assertEquals("airbusA320 not at airport", gatwick.takeOff(mockPlane.name, mockWeather));
        }
    }

// Extended Criteria
    @Nested
    @DisplayName("Test Stormy Weather Condition")
    class ChangeWeatherToStormy {
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
    }

    @Nested
    @DisplayName("Test Count Planes")
    class CountPlanes {
        Plane mockPlane3;
        Plane mockPlane4;
        Plane mockPlane5;
        @BeforeEach
        public void setUp() {
            mockPlane3 = Mockito.spy(new Plane("airbusA322"));
            mockPlane4 = Mockito.spy(new Plane("airbusA323"));
            mockPlane5 = Mockito.spy(new Plane("airbusA324"));
            gatwick.maxCapacity = 5;
        }
        @Test
        void countPlanesInHangar() {
            gatwick.land(mockPlane.name,mockWeather);
            gatwick.land(mockPlane2.name,mockWeather);
            gatwick.land(mockPlane3.name,mockWeather);
            gatwick.land(mockPlane4.name,mockWeather);
            gatwick.land(mockPlane5.name,mockWeather);
            Assertions.assertEquals(5, gatwick.countHangar());
        }
    }
}
