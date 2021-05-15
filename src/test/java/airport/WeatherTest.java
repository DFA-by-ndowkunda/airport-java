package airport;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;

public class WeatherTest {
    Weather weather;

    @Before
    public void setUp() {
        weather = Mockito.spy(new Weather());
    }

    @Test
    public void testTrueOutcome(){
        Mockito.doReturn(true).when(weather).isStorm();
        Assertions.assertTrue(weather.isStorm());
    }

    @Test
    public void testFalseOutcome(){
        Mockito.doReturn(false).when(weather).isStorm();
        Assertions.assertFalse(weather.isStorm());
    }


}