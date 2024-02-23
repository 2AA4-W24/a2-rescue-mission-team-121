package ca.mcmaster.se2aa4.island.team121;

import ca.mcmaster.se2aa4.island.team121.Records.RelativeMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RelativeMapTest {

    RelativeMap map;
    Heading start_heading = Heading.EAST;

    @BeforeEach
    public void setup() {
        map = new RelativeMap(start_heading);

    }

    @Test
    public void testGetDistanceToStart() {
        assertEquals(10, map.getDistanceToStart());
    }

    @Test
    public void testGetCurrentPos() {
        assertEquals(10, map.getDistanceToStart());
    }

    @Test
    public void testGetTileType() {
        assertEquals(TileType.UNKNOWN, map.getTileType(new Point(0, 0)));
    }

    @Test
    public void testGetCurrentHeading() {
        assertEquals(Heading.EAST, map.getCurrentHeading());
    }

    @Test
    public void testUpdateFly() {
        map.updateFly();
        assertEquals(new Point(1, 0), map.getCurrentPos());
    }

    @Test
    public void testUpdateTurn() {
        map.updateTurn(Heading.SOUTH);
        assertEquals(Heading.SOUTH, map.getCurrentHeading());
    }

    @Test
    public void testUpdateTurnSameHeading() {
        map.updateTurn(Heading.EAST);
        assertEquals(Heading.EAST, map.getCurrentHeading());
    }

    @Test
    public void testUpdateTurnOppositeHeading() {
        map.updateTurn(Heading.WEST);
        assertEquals(Heading.WEST, map.getCurrentHeading());
    }

    @Test
    public void testUpdateScan() {
        map.updateScan(TileType.CREEK);
        assertEquals(TileType.CREEK, map.getTileType(new Point(0, 0)));
    }

}
