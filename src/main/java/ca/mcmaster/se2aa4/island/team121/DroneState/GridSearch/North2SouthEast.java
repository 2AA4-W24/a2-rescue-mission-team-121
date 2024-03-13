package ca.mcmaster.se2aa4.island.team121.DroneState.GridSearch;

import ca.mcmaster.se2aa4.island.team121.DroneState.State;
import ca.mcmaster.se2aa4.island.team121.DroneState.Stop;
import ca.mcmaster.se2aa4.island.team121.Heading;
import ca.mcmaster.se2aa4.island.team121.Modules.Module;
import ca.mcmaster.se2aa4.island.team121.Modules.Radar;
import ca.mcmaster.se2aa4.island.team121.Records.AttributeRecord;
import ca.mcmaster.se2aa4.island.team121.Records.MapUpdater;
import ca.mcmaster.se2aa4.island.team121.Modules.Turner;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class North2SouthEast extends State {
    private State next;

    public North2SouthEast(MapUpdater map, AttributeRecord drone_attributes) {
        super(map, drone_attributes);
        this.cycle.add(new Turner(Heading.EAST));
        this.cycle.add(new Turner(Heading.SOUTH));
        this.cycle.add(new Radar(Heading.SOUTH));
    }

    // FIXME: Abstraction leak
    @Override
    public State getNext() {
        return next;
    }

    @Override
    public void update(JSONObject response) {
        //Sets next state to Stop if the echo is out of range otherwise sets next state to FlySouth
        next = ((Objects.equals(parser.echoGround(response), "OUT_OF_RANGE")) ? new Stop(map, drone_attributes) : new FlySouth(map, drone_attributes));
        if (step_count == 3) go_next = true;

    }
}