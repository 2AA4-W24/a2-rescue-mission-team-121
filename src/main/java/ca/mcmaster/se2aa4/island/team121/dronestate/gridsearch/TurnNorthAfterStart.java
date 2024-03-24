package ca.mcmaster.se2aa4.island.team121.dronestate.gridsearch;

import ca.mcmaster.se2aa4.island.team121.businessdrivenobjects.Heading;
import ca.mcmaster.se2aa4.island.team121.dronestate.State;
import ca.mcmaster.se2aa4.island.team121.modules.Radar;
import ca.mcmaster.se2aa4.island.team121.modules.Turner;
import ca.mcmaster.se2aa4.island.team121.records.MapUpdater;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;

public class TurnNorthAfterStart extends State {

    private final Logger logger = LogManager.getLogger();
    private int dist = 0;

    public TurnNorthAfterStart(MapUpdater map) {
        super(map);
        this.cycle.add(new Turner(map, Heading.NORTH));
        this.cycle.add(new Radar(map, Heading.NORTH));
    }

    @Override
    public State getNext() {
        return new FlyStraightNorth(map, dist);
    }

    @Override
    public void update(JSONObject response) {
        if (parser.echoGround(response).equals("GROUND")) {
            dist = parser.echoDistance(response);
        }
        if (step_count == 2) {
            go_next = true;
        }
    }
}
