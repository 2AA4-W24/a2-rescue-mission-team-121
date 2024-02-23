package ca.mcmaster.se2aa4.island.team121;

import ca.mcmaster.se2aa4.island.team121.Records.Point;
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

    // TODO: Implement getDistanceToStart.
    @Test
    public void testGetDistanceToStart() {
        assertEquals(10, map.getDistanceToStart());
    }

    @Test
    public void testGetStartingPos() {
        assertEquals(new Point(0, 0), map.getCurrentPos());
    }

    @Test
    public void testGetStartingTileType() {
        assertEquals(TileType.UNKNOWN, map.getTileType(new Point(0, 0)));
        assertEquals(TileType.UNKNOWN, map.getTileType(map.getCurrentPos()));
    }

    @Test
    public void testGetCurrentHeading() {
        assertEquals(start_heading, map.getCurrentHeading());
    }

    @Test
    public void testUpdateFly4Headings() {
        map.updateFly();
        assertEquals(new Point(1, 0), map.getCurrentPos());

        RelativeMap mapNorth = new RelativeMap(Heading.NORTH);
        mapNorth.updateFly();
        assertEquals(new Point(0, 1), mapNorth.getCurrentPos());

        RelativeMap mapSouth = new RelativeMap(Heading.SOUTH);
        mapSouth.updateFly();
        assertEquals(new Point(0, -1), mapSouth.getCurrentPos());

        RelativeMap mapWest = new RelativeMap(Heading.WEST);
        mapWest.updateFly();
        assertEquals(new Point(-1, 0), mapWest.getCurrentPos());
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

    // Not necessary as the drone cannot take a U-turn.
//    @Test
//    public void testUpdateTurnOppositeHeading() {
//        map.updateTurn(Heading.WEST);
//        assertEquals(Heading.WEST, map.getCurrentHeading());
//    }

    @Test
    public void testUpdateScan() {
        map.updateScan(TileType.CREEK);
        assertEquals(TileType.CREEK, map.getTileType(new Point(0, 0)));
    }

}
