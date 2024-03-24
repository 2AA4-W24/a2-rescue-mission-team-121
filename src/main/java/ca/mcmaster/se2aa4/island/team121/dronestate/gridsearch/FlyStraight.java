package ca.mcmaster.se2aa4.island.team121.dronestate.gridsearch;

import ca.mcmaster.se2aa4.island.team121.dronestate.State;
import ca.mcmaster.se2aa4.island.team121.modules.Flyer;
import ca.mcmaster.se2aa4.island.team121.records.MapUpdater;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;

public class FlyStraight extends State {

    private int flight_length;
    private final Logger logger = LogManager.getLogger();

    public FlyStraight(MapUpdater map, int dist) {
        super(map);
        this.cycle.add(new Flyer(map));
        flight_length = dist;
    }

    @Override
    public State getNext(){
        return new FlySouth(map);
    }

    @Override
    public void update(JSONObject response){
        if (step_count == flight_length+1) {
            go_next = true;
        }
    }
}
