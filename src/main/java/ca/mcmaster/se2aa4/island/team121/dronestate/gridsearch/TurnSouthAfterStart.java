package ca.mcmaster.se2aa4.island.team121.dronestate.gridsearch;

import ca.mcmaster.se2aa4.island.team121.businessdrivenobjects.Heading;
import ca.mcmaster.se2aa4.island.team121.modules.Radar;
import ca.mcmaster.se2aa4.island.team121.modules.Turner;
import ca.mcmaster.se2aa4.island.team121.records.MapUpdater;
import ca.mcmaster.se2aa4.island.team121.dronestate.State;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;

public class TurnSouthAfterStart extends State {

    private final Logger logger = LogManager.getLogger();
    private int dist = 0;

    public TurnSouthAfterStart(MapUpdater map) {
        super(map);
        this.cycle.add(new Turner(map, Heading.SOUTH));
        this.cycle.add(new Radar(map, Heading.SOUTH));
    }

    @Override
    public State getNext() {
        return new FlyStraight(map, dist);
    }

    @Override
    public void update(JSONObject response) {
        if ("GROUND".equals(parser.echoGround(response))) {
            dist = parser.echoDistance(response);
        }
        if (step_count == 2) {
            go_next = true;
        }
    }
}
