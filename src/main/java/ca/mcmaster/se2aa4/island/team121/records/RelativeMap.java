package ca.mcmaster.se2aa4.island.team121.records;

import ca.mcmaster.se2aa4.island.team121.Heading;
import ca.mcmaster.se2aa4.island.team121.TileRecord;
import ca.mcmaster.se2aa4.island.team121.TileType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class RelativeMap implements MapUpdater, MapInspector {

    private final Logger logger = LogManager.getLogger();
    protected final Map<Point, TileRecord> relative_map;
    private Point current_pos;
    private Heading current_heading;

    private Heading init_scan_heading;

    public RelativeMap(Heading start_heading) {
        this.relative_map = new HashMap<>();
        relative_map.put(new Point(0, 0), new TileRecord(TileType.UNKNOWN, Collections.emptyList()));
        this.current_pos = new Point(0, 0);
        this.current_heading = start_heading;
    }

    @Override
    public void updateScanHeading(Heading heading) {
        init_scan_heading = heading;
    }

    @Override
    public Heading getScanHeading() {
        return init_scan_heading;
    }
    @Override
    public void updateFly() {
        switch (current_heading) {
            case NORTH -> current_pos = new Point(current_pos.x(), current_pos.y() + 1);
            case EAST -> current_pos = new Point(current_pos.x() + 1, current_pos.y());
            case SOUTH -> current_pos = new Point(current_pos.x(), current_pos.y() - 1);
            case WEST -> current_pos = new Point(current_pos.x() - 1, current_pos.y());
            default -> throw new IllegalStateException("Unexpected value: " + current_heading);
        }

        if (!relative_map.containsKey(current_pos)) {
            relative_map.put(current_pos, new TileRecord(TileType.UNKNOWN, Collections.emptyList()));
        }
    }

    // Currently does not take into account the case where the drone is told take a U-turn,
    // but that case would most likely be handled before this method is called.
    @Override
    public void updateTurn(Heading new_heading) {
        if (new_heading == current_heading) {
            return;
        }

        updateFly();
        current_heading = new_heading;
        updateFly();

        if (!relative_map.containsKey(current_pos)) {
            relative_map.put(current_pos, new TileRecord(TileType.UNKNOWN, Collections.emptyList()));
        }
    }

    @Override
    public void updateScan(TileRecord new_type) {
        relative_map.put(new Point(current_pos.x(), current_pos.y()), new_type);
    }

    @Override
    public void displayMap() {
        for (Map.Entry<Point, TileRecord> entry : relative_map.entrySet()) {
            if (entry.getValue().type() != TileType.UNKNOWN) {
                logger.info("Position: " + entry.getKey() + ", TileRecord: " + entry.getValue());
            }
        }
    }

    @Override
    public Map<TileRecord, Double> getCreekSiteDistances() {
        Map<TileRecord, Double> creek_site_distances = new HashMap<>();

        Point site_point = new Point(0, 0); // If no site is found, then distance is calculated from (0, 0)
        for (Map.Entry<Point, TileRecord> entry : relative_map.entrySet()) {
            if (entry.getValue().type() == TileType.SITE) {
                site_point = entry.getKey();
            }
        }

        for (Map.Entry<Point, TileRecord> entry : relative_map.entrySet()) {
            if (entry.getValue().type() == TileType.CREEK) {
                creek_site_distances.put(entry.getValue(), entry.getKey().getDistance(site_point));
            }
        }

        return creek_site_distances;
    }
}
