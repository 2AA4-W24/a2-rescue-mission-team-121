package ca.mcmaster.se2aa4.island.team121.droneState.gridSearch;

import ca.mcmaster.se2aa4.island.team121.droneState.State;
import ca.mcmaster.se2aa4.island.team121.droneState.Stop;
import ca.mcmaster.se2aa4.island.team121.Heading;
import ca.mcmaster.se2aa4.island.team121.Modules.Flyer;
import ca.mcmaster.se2aa4.island.team121.Modules.Radar;
import ca.mcmaster.se2aa4.island.team121.Modules.Turner;
import ca.mcmaster.se2aa4.island.team121.Records.MapUpdater;
import org.json.JSONObject;

public class South2NorthProg extends State {

    private State next;

    public South2NorthProg(MapUpdater map) {
        super(map);
        this.cycle.add(new Turner(map, Heading.WEST));
        this.cycle.add(new Turner(map, Heading.SOUTH));
        this.cycle.add(new Turner(map, Heading.EAST));
        this.cycle.add(new Flyer(map));
        this.cycle.add(new Turner(map, Heading.NORTH));
        this.cycle.add(new Flyer(map));
        this.cycle.add(new Flyer(map));
        this.cycle.add(new Radar(map, Heading.NORTH));

    }

    // FIXME: Abstraction leak
    @Override
    public State getNext() {
        return next;
    }

    @Override
    public void update(JSONObject response) {
        if(parser.echoGround(response).equals("OUT_OF_RANGE")) {
            next = new Stop(map);
        } else {
            next = new FlyNorth(map);
        }
        if (step_count == 8) go_next = true;
    }
}
