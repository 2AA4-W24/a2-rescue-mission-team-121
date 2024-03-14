//<<<<<<< HEAD
////package ca.mcmaster.se2aa4.island.team121;
////
////import ca.mcmaster.se2aa4.island.team121.Records.Point;
////import ca.mcmaster.se2aa4.island.team121.Records.RelativeMap;
////import org.junit.jupiter.api.BeforeEach;
////import org.junit.jupiter.api.Test;
////import static org.junit.jupiter.api.Assertions.assertEquals;
////
////class TestRelativeMap extends RelativeMap {
////
////    public TestRelativeMap(Heading start_heading) {
////        super(start_heading);
////        // TODO Auto-generated constructor stub
////    }
////
////    TileType getTileType(Point p) {
////        if (!relative_map.containsKey(p))
////            return TileType.UNKNOWN;
////        return relative_map.get(p);
////    }
////}
////
////public class RelativeMapTest {
////
////    TestRelativeMap map;
////    Heading start_heading = Heading.EAST;
////
////    @BeforeEach
////    public void setup() {
////        map = new TestRelativeMap(start_heading);
////
////    }
////
////    // TODO: Implement getDistanceToStart.
////    @Test
////    public void testGetDistanceToStart() {
////        assertEquals(10, map.getDistanceToStart());
////    }
////
////    @Test
////    public void testGetTileTypeForUnknownPoint() {
////        assertEquals(TileType.UNKNOWN, map.getTileType(new Point(1, 1)));
////    }
////
////    @Test
////    public void testGetCurrentHeading() {
////        assertEquals(start_heading, map.getCurrentHeading());
////    }
////
////    @Test
////    public void testUpdateFly4Headings() {
////        map.updateFly();
////        assertEquals(new Point(1, 0), map.getCurrentPos());
////        assertEquals(TileType.UNKNOWN, map.getTileType(map.getCurrentPos()));
////    }
////
////    @Test
////    public void testUpdateFlyOntoScannedPoint() {
////        map.updateScan(TileType.CREEK);
////        map.updateFly();
////        map.updateFly();
////        map.updateFly();
////        map.updateTurn(Heading.NORTH);
////        map.updateTurn(Heading.WEST);
////        map.updateTurn(Heading.SOUTH);
////        map.updateTurn(Heading.WEST);
////        map.updateFly();
////
////        assertEquals(new Point(0, 0), map.getCurrentPos());
////        assertEquals(TileType.CREEK, map.getTileType(map.getCurrentPos()));
////    }
////
////    @Test
////    public void testUpdateTurn() {
////        map.updateTurn(Heading.SOUTH);
////        assertEquals(Heading.SOUTH, map.getCurrentHeading());
////        assertEquals(new Point(1, -1), map.getCurrentPos());
////
////        map.updateTurn(Heading.WEST);
////        assertEquals(Heading.WEST, map.getCurrentHeading());
////        assertEquals(new Point(0, -2), map.getCurrentPos());
////
////        map.updateTurn(Heading.NORTH);
////        assertEquals(Heading.NORTH, map.getCurrentHeading());
////        assertEquals(new Point(-1, -1), map.getCurrentPos());
////
////        map.updateTurn(Heading.EAST);
////        assertEquals(Heading.EAST, map.getCurrentHeading());
////        assertEquals(new Point(0, 0), map.getCurrentPos());
////    }
////
////    @Test
////    public void testUpdateTurnOntoScannedPoint() {
////        map.updateScan(TileType.CREEK);
////        map.updateTurn(Heading.NORTH);
////        map.updateTurn(Heading.WEST);
////        map.updateTurn(Heading.SOUTH);
////        map.updateTurn(Heading.EAST);
////
////        assertEquals(new Point(0, 0), map.getCurrentPos());
////        assertEquals(TileType.CREEK, map.getTileType(map.getCurrentPos()));
////    }
////
////    @Test
////    public void testUpdateTurnSameHeading() {
////        map.updateTurn(Heading.EAST);
////        assertEquals(Heading.EAST, map.getCurrentHeading());
////        assertEquals(new Point(0, 0), map.getCurrentPos());
////    }
////
////    // Not necessary as the drone cannot take a U-turn.
////    // @Test
////    // public void testUpdateTurnOppositeHeading() {
////    // map.updateTurn(Heading.WEST);
////    // assertEquals(Heading.WEST, map.getCurrentHeading());
////    // }
////
////    @Test
////    public void testUpdateScan() {
////        map.updateScan(TileType.CREEK);
////        assertEquals(TileType.CREEK, map.getTileType(map.getCurrentPos()));
////    }
////
////    // @Test
////    // public void testIsOverGround() {
////    // map.updateScan(TileType.GROUND);
////    // assertEquals(true, map.isOverGound());
////    // }
////}
//=======
//package ca.mcmaster.se2aa4.island.team121;
//
//import ca.mcmaster.se2aa4.island.team121.Records.Point;
//import ca.mcmaster.se2aa4.island.team121.Records.RelativeMap;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//class TestRelativeMap extends RelativeMap {
//
//    public TestRelativeMap(Heading start_heading) {
//        super(start_heading);
//        // TODO Auto-generated constructor stub
//    }
//
//    TileType getTileType(Point p) {
//        if (!relative_map.containsKey(p))
//            return TileType.UNKNOWN;
//        return relative_map.get(p);
//    }
//}
//
//public class RelativeMapTest {
//
//    TestRelativeMap map;
//    Heading start_heading = Heading.EAST;
//
//    @BeforeEach
//    public void setup() {
//        map = new TestRelativeMap(start_heading);
//
//    }
//
//    @Test
//    public void testGetTileTypeForUnknownPoint() {
//        assertEquals(TileType.UNKNOWN, map.getTileType(new Point(1, 1)));
//    }
//
//    @Test
//    public void testGetCurrentHeading() {
//        assertEquals(start_heading, map.getCurrentHeading());
//    }
//
//    @Test
//    public void testUpdateFly4Headings() {
//        map.updateFly();
//        assertEquals(new Point(1, 0), map.getCurrentPos());
//        assertEquals(TileType.UNKNOWN, map.getTileType(map.getCurrentPos()));
//    }
//
//    @Test
//    public void testUpdateFlyOntoScannedPoint() {
//        map.updateScan(TileType.CREEK);
//        map.updateFly();
//        map.updateFly();
//        map.updateFly();
//        map.updateTurn(Heading.NORTH);
//        map.updateTurn(Heading.WEST);
//        map.updateTurn(Heading.SOUTH);
//        map.updateTurn(Heading.WEST);
//        map.updateFly();
//
//        assertEquals(new Point(0, 0), map.getCurrentPos());
//        assertEquals(TileType.CREEK, map.getTileType(map.getCurrentPos()));
//    }
//
//    @Test
//    public void testUpdateTurn() {
//        map.updateTurn(Heading.SOUTH);
//        assertEquals(Heading.SOUTH, map.getCurrentHeading());
//        assertEquals(new Point(1, -1), map.getCurrentPos());
//
//        map.updateTurn(Heading.WEST);
//        assertEquals(Heading.WEST, map.getCurrentHeading());
//        assertEquals(new Point(0, -2), map.getCurrentPos());
//
//        map.updateTurn(Heading.NORTH);
//        assertEquals(Heading.NORTH, map.getCurrentHeading());
//        assertEquals(new Point(-1, -1), map.getCurrentPos());
//
//        map.updateTurn(Heading.EAST);
//        assertEquals(Heading.EAST, map.getCurrentHeading());
//        assertEquals(new Point(0, 0), map.getCurrentPos());
//    }
//
//    @Test
//    public void testUpdateTurnOntoScannedPoint() {
//        map.updateScan(TileType.CREEK);
//        map.updateTurn(Heading.NORTH);
//        map.updateTurn(Heading.WEST);
//        map.updateTurn(Heading.SOUTH);
//        map.updateTurn(Heading.EAST);
//
//        assertEquals(new Point(0, 0), map.getCurrentPos());
//        assertEquals(TileType.CREEK, map.getTileType(map.getCurrentPos()));
//    }
//
//    @Test
//    public void testUpdateTurnSameHeading() {
//        map.updateTurn(Heading.EAST);
//        assertEquals(Heading.EAST, map.getCurrentHeading());
//        assertEquals(new Point(0, 0), map.getCurrentPos());
//    }
//
//    // Not necessary as the drone cannot take a U-turn.
//    // @Test
//    // public void testUpdateTurnOppositeHeading() {
//    // map.updateTurn(Heading.WEST);
//    // assertEquals(Heading.WEST, map.getCurrentHeading());
//    // }
//
//    @Test
//    public void testUpdateScan() {
//        map.updateScan(TileType.CREEK);
//        assertEquals(TileType.CREEK, map.getTileType(map.getCurrentPos()));
//    }
//
//    // @Test
//    // public void testIsOverGround() {
//    // map.updateScan(TileType.GROUND);
//    // assertEquals(true, map.isOverGound());
//    // }
//}
//>>>>>>> e338e4ef109b52dbc0205a0d3f9998f4addf38e1
