package ca.mcmaster.se2aa4.island.team121.Records;

import ca.mcmaster.se2aa4.island.team121.Heading;
import ca.mcmaster.se2aa4.island.team121.TileRecord;
import ca.mcmaster.se2aa4.island.team121.TileType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class RelativeMap implements MapUpdater {
    private ArrayList<String> creek_ids = new ArrayList<String>();
    private final Logger logger = LogManager.getLogger();
    protected Map<Point, TileRecord> relative_map;
    Point current_pos;
    Heading current_heading;

    public RelativeMap(Heading start_heading) {
        this.relative_map = new HashMap<>();
        relative_map.put(new Point(0, 0), new TileRecord(TileType.UNKNOWN, Collections.emptyList()));
        this.current_pos = new Point(0, 0);
        this.current_heading = start_heading;
    }

    // TODO: Implement this method.
    public int getDistanceToStart() {
        return 10;
    }

    public Map<Point, TileRecord> getRelativeMap() {
        return relative_map;
    }
    @Override
    public void updateFly() {
        switch (current_heading) {
            case NORTH -> current_pos = new Point(current_pos.x(), current_pos.y() + 1);
            case EAST -> current_pos = new Point(current_pos.x() + 1, current_pos.y());
            case SOUTH -> current_pos = new Point(current_pos.x(), current_pos.y() - 1);
            case WEST -> current_pos = new Point(current_pos.x() - 1, current_pos.y());
        }

        if (!relative_map.containsKey(current_pos))
            relative_map.put(current_pos, new TileRecord(TileType.UNKNOWN, Collections.emptyList()));
    }

    // Currently does not take into account the case where the drone is told take a
    // U-turn,
    // but that case would most likely be handled before this method is called.
    @Override
    public void updateTurn(Heading new_heading) {
        if (new_heading == current_heading) {
            return;
        }
        updateFly();
        current_heading = new_heading;
        updateFly();

        if (!relative_map.containsKey(current_pos))
            relative_map.put(current_pos, new TileRecord(TileType.UNKNOWN, Collections.emptyList()));
    }


    @Override
    public void updateScan(TileRecord new_type) {
        relative_map.put(current_pos, new_type);
    }


    public Point getCurrentPos() {
        return new Point(current_pos.x(), current_pos.y());
    }

    // FIXME: Same abstraction leak as getTileType().
    public Heading getCurrentHeading() {
        return current_heading;
    }
}
