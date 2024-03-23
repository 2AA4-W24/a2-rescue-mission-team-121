//package ca.mcmaster.se2aa4.island.team121;
//
//import ca.mcmaster.se2aa4.island.team121.Records.MapUpdater;
//import ca.mcmaster.se2aa4.island.team121.Records.RelativeMap;
//import org.junit.jupiter.api.BeforeEach;
//import ca.mcmaster.se2aa4.island.team121.Records.map;
//import ca.mcmaster.se2aa4.island.team121.Records.MapUpdater;
//import ca.mcmaster.se2aa4.island.team121.Heading;
//import ca.mcmaster.se2aa4.island.team121.TileRecord;
//import ca.mcmaster.se2aa4.island.team121.TileType;
//import ca.mcmaster.se2aa4.island.team121.Records.Point;
//
//import org.junit.jupiter.api.Test;
//
//import java.util.Collections;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class mapTest {
//
//    private RelativeMap map = new RelativeMap(Heading.NORTH)
//    @Test
//    void testUpdateFly() {
//        map.updateFly();
//        assertEquals(new Point(0, 1), map.getCurrentPos());
//    }
//
//    @Test
//    void testUpdateTurn() {
//        map.updateTurn(Heading.EAST);
//        assertEquals(Heading.EAST, map.getCurrentHeading());
//        assertEquals(new Point(1, 1), map.getCurrentPos());
//    }
//
//    @Test
//    void testUpdateScan() {
//        TileRecord tileRecord = new TileRecord(TileType.UNKNOWN, Collections.emptyList());
//        map.updateScan(tileRecord);
//        assertEquals(tileRecord, map.relative_map.get(map.getCurrentPos()));
//    }
//
//    @Test
//        assertEquals(new Point(0, 0), map.getCurrentPos());
//    }
//
//    @Test
//    void testGetCurrentHeading() {
//        assertEquals(Heading.NORTH, map.getCurrentHeading());
//    }
//}