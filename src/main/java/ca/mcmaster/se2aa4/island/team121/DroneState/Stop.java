package ca.mcmaster.se2aa4.island.team121.DroneState;

import ca.mcmaster.se2aa4.island.team121.Modules.*;
import ca.mcmaster.se2aa4.island.team121.Modules.Module;
import ca.mcmaster.se2aa4.island.team121.Records.AttributeRecord;
import ca.mcmaster.se2aa4.island.team121.Records.MapUpdater;
import ca.mcmaster.se2aa4.island.team121.Records.Point;
import ca.mcmaster.se2aa4.island.team121.TileRecord;
import org.json.JSONObject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Stop extends State {
    private final Logger logger = LogManager.getLogger();

    public Stop(MapUpdater map, AttributeRecord drone_attributes) {
        super(map, drone_attributes);
        this.cycle.add(new Stopper(map));
    }
    @Override
    public State getNext() {
        // Does not have a next
        return null;
    }

    @Override
    public void update(JSONObject json) {
        // Do nothing
    }
}
