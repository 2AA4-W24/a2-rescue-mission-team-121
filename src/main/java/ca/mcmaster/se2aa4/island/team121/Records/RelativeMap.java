package ca.mcmaster.se2aa4.island.team121.Records;

import ca.mcmaster.se2aa4.island.team121.Heading;
import ca.mcmaster.se2aa4.island.team121.TileType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class RelativeMap implements MapUpdater {

    Map<Point, TileType> relative_map;
    Point current_pos;
    Heading current_heading;
    private final Logger logger = LogManager.getLogger();

    public RelativeMap(Heading start_heading) {
        this.relative_map = new HashMap<>();
        relative_map.put(new Point(0, 0), TileType.UNKNOWN);
        this.current_pos = new Point(0, 0);
        this.current_heading = start_heading;
    }

    public int getDistanceToStart() {
        return 10;
    }

    public void updateFly() {
        logger.info("** Updating position after flying");

        switch (current_heading) {
            case NORTH -> current_pos = new Point(current_pos.x(), current_pos.y() + 1);
            case EAST -> current_pos = new Point(current_pos.x() + 1, current_pos.y());
            case SOUTH -> current_pos = new Point(current_pos.x(), current_pos.y() - 1);
            case WEST -> current_pos = new Point(current_pos.x() - 1, current_pos.y());
        }

        logger.info("Current position: {}", current_pos);
        if (!relative_map.containsKey(current_pos))
            relative_map.put(current_pos, TileType.UNKNOWN);
    }

    public void updateTurn(Heading new_heading) {
        logger.info("** Updating map after turning");

        if (new_heading == current_heading) {
            logger.error("The drone is facing the same direction");
            return;
        }

        logger.info("Calling updateFly()");
        updateFly();
        current_heading = new_heading;
        updateFly();
        logger.info("Current heading: {}", current_heading);

        if (!relative_map.containsKey(current_pos))
            relative_map.put(current_pos, TileType.UNKNOWN);
    }

    public void updateScan(TileType new_type) {
        logger.info("** Updating map after scanning");
        relative_map.put(current_pos, new_type);
        logger.info("New tile type: {}", relative_map.get(current_pos));
    }

    public Point getCurrentPos() {
        return new Point(current_pos.x(), current_pos.y());
    }

    public TileType getTileType(Point point_query) {
        // Abstraction leak here as it returns the Enum value, but Enums cannot be cloned.
        // Possible solution would be to return the name of the Enum value instead.
        return relative_map.get(point_query);
    }

    public Heading getCurrentHeading() {
        // Same abstraction leak as getCurrentTileType()
        return current_heading;
    }
}
