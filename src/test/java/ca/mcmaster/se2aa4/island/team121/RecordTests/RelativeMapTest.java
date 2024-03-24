package ca.mcmaster.se2aa4.island.team121.RecordTests;

import ca.mcmaster.se2aa4.island.team121.BusinessDrivenObjects.TileRecord;
import ca.mcmaster.se2aa4.island.team121.BusinessDrivenObjects.TileType;
import ca.mcmaster.se2aa4.island.team121.Records.RelativeMap;
import ca.mcmaster.se2aa4.island.team121.BusinessDrivenObjects.Heading;
import ca.mcmaster.se2aa4.island.team121.BusinessDrivenObjects.Point;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TestMap extends RelativeMap {

    public TestMap(Heading start_heading) {
        super(start_heading);
    }

    public Point getCurrentPos() {
        return current_pos;
    }

    public Heading getCurrentHeading() {
        return current_heading;
    }

    public TileRecord getTile() {
        return relative_map.get(current_pos);
    }
}

public class RelativeMapTest {

    private TestMap north_map;
    private TestMap east_map;

    @BeforeEach
    public void setUp() {
        north_map = new TestMap(Heading.NORTH);
        east_map = new TestMap(Heading.EAST);
    }

    @Test
    void testUpdateFly() {
        Point expected_pos = new Point(0, 1);
        north_map.updateFly();
        assertEquals(expected_pos, north_map.getCurrentPos());

        expected_pos = new Point(1, 0);
        east_map.updateFly();
        assertEquals(expected_pos, east_map.getCurrentPos());
    }

    @Test
    void testUpdateTurn() {
        Point expected_pos = new Point(1, 1);
        Heading expected_heading = Heading.EAST;
        north_map.updateTurn(Heading.EAST);
        assertEquals(expected_heading, north_map.getCurrentHeading());
        assertEquals(expected_pos, north_map.getCurrentPos());

        expected_pos = new Point(1, -1);
        expected_heading = Heading.SOUTH;
        east_map.updateTurn(Heading.SOUTH);
        assertEquals(expected_heading, east_map.getCurrentHeading());
        assertEquals(expected_pos, east_map.getCurrentPos());
    }

    @Test
    void testUpdateScan() {
        assertEquals(new TileRecord(TileType.UNKNOWN, Collections.emptyList()), north_map.getTile());

        List<String> test_ids = new ArrayList<>();
        test_ids.add("test_id");

        TileRecord expected_tile = new TileRecord(TileType.UNKNOWN, test_ids);
        north_map.updateScan(expected_tile);
        assertEquals(expected_tile.id(), north_map.getTile().id());
        assertEquals(expected_tile.type(), north_map.getTile().type());
    }

    @Test
    void testGetCreekSiteDistances() {
        // Creek: Point(-4, 3)
        Map<TileRecord, Double> expected_distances = new HashMap<>();
        expected_distances.put(new TileRecord(TileType.CREEK, Collections.emptyList()), 5.0);

        north_map.updateFly();
        north_map.updateFly();
        north_map.updateTurn(Heading.WEST);
        north_map.updateFly();
        north_map.updateFly();
        north_map.updateFly();
        north_map.updateScan(new TileRecord(TileType.CREEK, Collections.emptyList()));

        assertEquals(expected_distances, north_map.getCreekSiteDistances());
    }
}