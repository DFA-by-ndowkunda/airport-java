package airport;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AirportTest {
    @Test
    void testisFullTrue() {
        Airport airport = new Airport();
        assertEquals( airport.isFull(100),"airport full");
    }
    @Test
    void testisFullFalse() {
        Airport airport = new Airport();
        assertEquals( airport.isFull(90),"airport not full");
    }
}
