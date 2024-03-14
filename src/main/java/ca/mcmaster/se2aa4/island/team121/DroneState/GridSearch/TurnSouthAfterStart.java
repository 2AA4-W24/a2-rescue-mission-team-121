package ca.mcmaster.se2aa4.island.team121.DroneState.GridSearch;

import ca.mcmaster.se2aa4.island.team121.DroneState.FlyStraight;
import ca.mcmaster.se2aa4.island.team121.DroneState.State;
import ca.mcmaster.se2aa4.island.team121.Heading;
import ca.mcmaster.se2aa4.island.team121.Modules.*;
import ca.mcmaster.se2aa4.island.team121.Records.AttributeRecord;
import ca.mcmaster.se2aa4.island.team121.Records.MapUpdater;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;

public class TurnSouthAfterStart extends State {

    private final Logger logger = LogManager.getLogger();

    private int dist;

    public TurnSouthAfterStart(MapUpdater map, AttributeRecord drone_attributes) {
        super(map, drone_attributes);
        this.cycle.add(new Turner(map, Heading.SOUTH));
        this.cycle.add(new Radar(map, Heading.SOUTH));
    }

    @Override
    public State getNext() {
        return new FlyStraight(map, drone_attributes, dist);
    }

    @Override
    public void update(JSONObject response) {
        dist = parser.echoDistance(response);
        if (step_count == 2)
            go_next = true;
    }
}
