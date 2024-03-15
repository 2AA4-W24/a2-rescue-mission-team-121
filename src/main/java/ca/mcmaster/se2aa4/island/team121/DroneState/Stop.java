package ca.mcmaster.se2aa4.island.team121.DroneState;

import ca.mcmaster.se2aa4.island.team121.Modules.*;
import ca.mcmaster.se2aa4.island.team121.Records.MapUpdater;
import org.json.JSONObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Stop extends State {
    private final Logger logger = LogManager.getLogger();

    public Stop(MapUpdater map) {
        super(map);
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
