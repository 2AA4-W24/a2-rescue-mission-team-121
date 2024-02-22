package ca.mcmaster.se2aa4.island.team121.Records;

import ca.mcmaster.se2aa4.island.team121.Heading;
import ca.mcmaster.se2aa4.island.team121.TileType;

import java.util.HashMap;
import java.util.Map;

public class RelativeMap implements MapUpdater {

    Map<Point, TileType> relative_map;
    Point current_pos;
    Heading current_heading;

    public RelativeMap() {
        this.relative_map = new HashMap<>();
        relative_map.put(new Point(0, 0), TileType.UNKNOWN);
    }

    public int getDistanceToStart() {
        return 10;
    }

    public void updateFly() {
        return;
    }

    public void updateTurn() {
        return;
    }

    public void updateScan() {
        return;
    }
}
