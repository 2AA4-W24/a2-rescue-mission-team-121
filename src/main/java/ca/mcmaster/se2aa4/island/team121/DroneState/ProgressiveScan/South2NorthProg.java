package ca.mcmaster.se2aa4.island.team121.DroneState.ProgressiveScan;

import ca.mcmaster.se2aa4.island.team121.DroneState.State;
import ca.mcmaster.se2aa4.island.team121.DroneState.Stop;
import ca.mcmaster.se2aa4.island.team121.Heading;
import ca.mcmaster.se2aa4.island.team121.Modules.Flyer;
import ca.mcmaster.se2aa4.island.team121.Modules.Radar;
import ca.mcmaster.se2aa4.island.team121.Modules.Turner;
import ca.mcmaster.se2aa4.island.team121.Records.AttributeRecord;
import ca.mcmaster.se2aa4.island.team121.Records.MapUpdater;
import org.json.JSONObject;

public class South2NorthProg extends State {

    private State next;

    public South2NorthProg(MapUpdater map, AttributeRecord drone_attributes) {
        super(map, drone_attributes);
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
            next = new Stop(map, drone_attributes);
        } else {
            next = new FlyNorth(map, drone_attributes);
        }
        if (step_count == 8) go_next = true;
    }
}
