package ca.mcmaster.se2aa4.island.team121.dronestate.doubleinterlaced;

import ca.mcmaster.se2aa4.island.team121.businessdrivenobjects.Heading;
import ca.mcmaster.se2aa4.island.team121.modules.Radar;
import ca.mcmaster.se2aa4.island.team121.modules.Turner;
import ca.mcmaster.se2aa4.island.team121.records.MapUpdater;
import ca.mcmaster.se2aa4.island.team121.dronestate.State;
import org.json.JSONObject;

public class TurnAfterStartDI extends State {
    private int dist = 0;
    private final Heading heading;
    public TurnAfterStartDI(MapUpdater map, Heading heading) {
        super(map);
        this.heading=heading;
        this.cycle.add(new Turner(map, heading));
        this.cycle.add(new Radar(map, heading));
    }

    @Override
    public State getNext() {
        return new FlyStraightDI(map, dist, heading);
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
