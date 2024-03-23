package ca.mcmaster.se2aa4.island.team121.droneState.gridSearch;

import ca.mcmaster.se2aa4.island.team121.Heading;
import ca.mcmaster.se2aa4.island.team121.Modules.Radar;
import ca.mcmaster.se2aa4.island.team121.Modules.Turner;
import ca.mcmaster.se2aa4.island.team121.Records.MapUpdater;
import ca.mcmaster.se2aa4.island.team121.droneState.State;
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
        if (parser.echoGround(response).equals("GROUND")) {
            dist = parser.echoDistance(response);
        }
        if (step_count == 2)
            go_next = true;
    }
}
