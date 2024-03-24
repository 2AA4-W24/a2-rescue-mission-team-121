package ca.mcmaster.se2aa4.island.team121.dronestate.doubleinterlaced;

import ca.mcmaster.se2aa4.island.team121.businessdrivenobjects.Heading;
import ca.mcmaster.se2aa4.island.team121.modules.Flyer;
import ca.mcmaster.se2aa4.island.team121.modules.Radar;
import ca.mcmaster.se2aa4.island.team121.records.MapUpdater;
import ca.mcmaster.se2aa4.island.team121.dronestate.State;
import org.json.JSONObject;

public class GridSearchStartDI extends State {

    private State next;
    public GridSearchStartDI(MapUpdater map) {
        super(map);
        this.cycle.add(new Radar(map, Heading.NORTH)); //1
        this.cycle.add(new Radar(map, Heading.SOUTH)); //2
        this.cycle.add(new Flyer(map));
    }

    @Override
    public State getNext() {
        return next;
    }

    @Override
    public void update(JSONObject response) {
        // Check if we found ground from Radar
        if ("GROUND".equals(parser.echoGround(response)) && step_count % 3 == 1) {
            next = new TurnAfterStartDI(map, Heading.NORTH);
            go_next= true;
        } else if ("GROUND".equals(parser.echoGround(response)) && step_count % 3 == 2) {
            next = new TurnAfterStartDI(map, Heading.SOUTH);
            go_next= true;
        }
    }
}