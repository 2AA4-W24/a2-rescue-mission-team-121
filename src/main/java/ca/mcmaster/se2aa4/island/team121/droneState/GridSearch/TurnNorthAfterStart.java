package ca.mcmaster.se2aa4.island.team121.droneState.GridSearch;

import ca.mcmaster.se2aa4.island.team121.Heading;
import ca.mcmaster.se2aa4.island.team121.Modules.Radar;
import ca.mcmaster.se2aa4.island.team121.Modules.Turner;
import ca.mcmaster.se2aa4.island.team121.Records.MapUpdater;
import ca.mcmaster.se2aa4.island.team121.droneState.State;
import org.json.JSONObject;

public class TurnNorthAfterStart extends State {
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
        if (step_count == 2)
            go_next = true;
    }
}
