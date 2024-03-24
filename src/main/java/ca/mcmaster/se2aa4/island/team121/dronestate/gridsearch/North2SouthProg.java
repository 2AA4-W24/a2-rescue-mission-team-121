package ca.mcmaster.se2aa4.island.team121.dronestate.gridsearch;

import ca.mcmaster.se2aa4.island.team121.dronestate.State;
import ca.mcmaster.se2aa4.island.team121.dronestate.Stop;
import ca.mcmaster.se2aa4.island.team121.businessdrivenobjects.Heading;
import ca.mcmaster.se2aa4.island.team121.modules.Flyer;
import ca.mcmaster.se2aa4.island.team121.modules.Radar;
import ca.mcmaster.se2aa4.island.team121.modules.Turner;
import ca.mcmaster.se2aa4.island.team121.records.MapUpdater;
import org.json.JSONObject;

public class North2SouthProg extends State {

    private State next;

    public North2SouthProg(MapUpdater map) {
        super(map);
        this.cycle.add(new Turner(map, Heading.WEST));
        this.cycle.add(new Turner(map, Heading.NORTH));
        this.cycle.add(new Turner(map, Heading.EAST));
        this.cycle.add(new Flyer(map));
        this.cycle.add(new Turner(map, Heading.SOUTH));
        this.cycle.add(new Flyer(map));
        this.cycle.add(new Flyer(map));
        this.cycle.add(new Radar(map, Heading.SOUTH));
    }

    // FIXME: Abstraction leak
    @Override
    public State getNext() {
        return next;
    }

    @Override
    public void update(JSONObject response) {
        if(parser.echoGround(response).equals("OUT_OF_RANGE")){
            next = new Stop(map);
        } else {
            next = new FlySouth(map);
        }
        if (step_count == 8) go_next = true;
    }
}