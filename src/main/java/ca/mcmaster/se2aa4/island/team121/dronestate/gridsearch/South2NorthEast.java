package ca.mcmaster.se2aa4.island.team121.dronestate.gridsearch;

import ca.mcmaster.se2aa4.island.team121.businessdrivenobjects.Heading;
import ca.mcmaster.se2aa4.island.team121.modules.Radar;
import ca.mcmaster.se2aa4.island.team121.modules.Turner;
import ca.mcmaster.se2aa4.island.team121.records.MapUpdater;
import ca.mcmaster.se2aa4.island.team121.dronestate.State;
import ca.mcmaster.se2aa4.island.team121.dronestate.Stop;
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
        next = Objects.equals("OUT_OF_RANGE",parser.echoGround(response)) ? new Stop(map) : new FlyNorth(map);
        if (step_count == 3) {
            go_next = true;
        }
    }
}