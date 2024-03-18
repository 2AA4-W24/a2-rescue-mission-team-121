//package ca.mcmaster.se2aa4.island.team121;
//
//import org.junit.jupiter.api.BeforeEach;
//import ca.mcmaster.se2aa4.island.team121.Records.RelativeMap;
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
//class RelativeMapTest {
//    private RelativeMap relativeMap;
//
//    @BeforeEach
//    void setUp() {
//        relativeMap = new RelativeMap(Heading.NORTH);
//    }
//
//    @Test
//    void testUpdateFly() {
//        relativeMap.updateFly();
//        assertEquals(new Point(0, 1), relativeMap.getCurrentPos());
//    }
//
//    @Test
//    void testUpdateTurn() {
//        relativeMap.updateTurn(Heading.EAST);
//        assertEquals(Heading.EAST, relativeMap.getCurrentHeading());
//        assertEquals(new Point(1, 1), relativeMap.getCurrentPos());
//    }
//
//    @Test
//    void testUpdateScan() {
//        TileRecord tileRecord = new TileRecord(TileType.UNKNOWN, Collections.emptyList());
//        relativeMap.updateScan(tileRecord);
//        assertEquals(tileRecord, relativeMap.relative_map.get(relativeMap.getCurrentPos()));
//    }
//
//    @Test
//        assertEquals(new Point(0, 0), relativeMap.getCurrentPos());
//    }
//
//    @Test
//    void testGetCurrentHeading() {
//        assertEquals(Heading.NORTH, relativeMap.getCurrentHeading());
//    }
//}