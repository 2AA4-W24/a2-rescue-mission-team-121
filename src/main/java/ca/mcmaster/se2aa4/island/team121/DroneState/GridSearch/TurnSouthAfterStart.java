package ca.mcmaster.se2aa4.island.team121.DroneState.GridSearch;

import ca.mcmaster.se2aa4.island.team121.DroneState.State;
import ca.mcmaster.se2aa4.island.team121.Heading;
import ca.mcmaster.se2aa4.island.team121.Modules.*;
import ca.mcmaster.se2aa4.island.team121.Modules.Module;
import ca.mcmaster.se2aa4.island.team121.Records.AttributeRecord;
import ca.mcmaster.se2aa4.island.team121.Records.MapUpdater;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class TurnSouthAfterStart extends State {

    private final Logger logger = LogManager.getLogger();

    public TurnSouthAfterStart(MapUpdater map, AttributeRecord drone_attributes) {
        super(map, drone_attributes);
        this.cycle.add(new Turner(Heading.SOUTH));
    }

    @Override
    public State getNext() {
        return new FindBeach(map, drone_attributes);
    }

    @Override
    public void update(JSONObject json) {
        go_next = true;
    }
}
