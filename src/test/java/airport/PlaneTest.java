package airport;

import org.junit.jupiter.api.*;

class PlaneTest {
    Plane plane;

    @Test
    void planeNameExists() {
        Plane plane = new Plane("airbusA320");
        Assertions.assertEquals("airbusA320",plane.getName());
    }
}