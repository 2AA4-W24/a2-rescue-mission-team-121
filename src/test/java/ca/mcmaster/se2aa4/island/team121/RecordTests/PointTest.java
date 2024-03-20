package ca.mcmaster.se2aa4.island.team121.RecordTests;

import ca.mcmaster.se2aa4.island.team121.Records.Point;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PointTest {
    @Test
    public void getDistanceTest() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(3, 4);
        assertEquals(5, p1.getDistance(p2));

        p1 = new Point(0, 0);
        p2 = new Point(0, 0);
        assertEquals(0, p1.getDistance(p2));

        p1 = new Point(0, 0);
        p2 = new Point(0, 1);
        assertEquals(1, p1.getDistance(p2));

        p1 = new Point(0, 0);
        p2 = new Point(1, 0);
        assertEquals(1, p1.getDistance(p2));

        p1 = new Point(-100, 100);
        p2 = new Point(100, -100);
        assertEquals(282.842712474619, p1.getDistance(p2));
    }
}
