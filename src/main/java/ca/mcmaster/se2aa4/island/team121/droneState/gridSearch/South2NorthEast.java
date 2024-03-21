package ca.mcmaster.se2aa4.island.team121.droneState.gridSearch;

import ca.mcmaster.se2aa4.island.team121.droneState.State;
import ca.mcmaster.se2aa4.island.team121.droneState.Stop;
import ca.mcmaster.se2aa4.island.team121.Heading;
import ca.mcmaster.se2aa4.island.team121.Modules.Radar;
import ca.mcmaster.se2aa4.island.team121.Modules.Turner;
import ca.mcmaster.se2aa4.island.team121.Records.MapUpdater;
import org.json.JSONObject;
import java.util.Objects;

public class South2NorthEast extends State {

    private State next;

    public South2NorthEast(MapUpdater map) {
        super(map);
        this.cycle.add(new Turner(map, Heading.EAST));
        this.cycle.add(new Turner(map, Heading.NORTH));
        this.cycle.add(new Radar(map, Heading.NORTH));

    }

    // FIXME: Abstraction leak
    @Override
    public State getNext() {
        return next;
    }

    @Override
    public void update(JSONObject response) {
        next = ((Objects.equals(parser.echoGround(response), "OUT_OF_RANGE")) ? new Stop(map) : new FlyNorth(map));
        if (step_count == 3) go_next = true;
    }
}