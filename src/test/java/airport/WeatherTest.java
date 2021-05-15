package airport;

import org.junit.jupiter.api.*;
import org.mockito.Mockito;

public class WeatherTest {
    Weather spyWeather;

    @BeforeEach
    public void setUp() {
        spyWeather = Mockito.spy(new Weather());
    }

    @Test
    public void isStormTrueOutcome(){
        Mockito.doReturn(true).when(spyWeather).isStorm();
        Assertions.assertTrue(spyWeather.isStorm());
    }

    @Test
    public void isStormFalseOutcome(){
        Mockito.doReturn(false).when(spyWeather).isStorm();
        Assertions.assertFalse(spyWeather.isStorm());
    }
}