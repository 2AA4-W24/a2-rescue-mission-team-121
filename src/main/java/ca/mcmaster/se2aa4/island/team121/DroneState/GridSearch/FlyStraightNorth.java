package ca.mcmaster.se2aa4.island.team121.DroneState.GridSearch;

import ca.mcmaster.se2aa4.island.team121.DroneState.State;
import ca.mcmaster.se2aa4.island.team121.Modules.Flyer;
import ca.mcmaster.se2aa4.island.team121.Records.AttributeRecord;
import ca.mcmaster.se2aa4.island.team121.Records.MapUpdater;
import ca.mcmaster.se2aa4.island.team121.TileRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;

public class FlyStraightNorth extends State {

    private int flight_length;
    private final Logger logger = LogManager.getLogger();

    public FlyStraightNorth(MapUpdater map, int dist) {
        super(map);
        this.cycle.add(new Flyer(map));
        flight_length = dist;
    }

    @Override
    public State getNext(){
        return new FlyNorth(map);
    }

    @Override
    public void update(JSONObject response){
        if (step_count == flight_length+1) {
            go_next = true;
            logger.info("beach found complete");
        }
    }
}
