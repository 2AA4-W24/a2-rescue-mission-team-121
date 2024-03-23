package ca.mcmaster.se2aa4.island.team121.droneState.doubleInterlaced;

import ca.mcmaster.se2aa4.island.team121.Heading;
import ca.mcmaster.se2aa4.island.team121.Modules.Flyer;
import ca.mcmaster.se2aa4.island.team121.Modules.Turner;
import ca.mcmaster.se2aa4.island.team121.Records.MapUpdater;
import ca.mcmaster.se2aa4.island.team121.droneState.State;
import org.json.JSONObject;

public class TurnBackNorthWest extends State {

    public TurnBackNorthWest(MapUpdater map) {
        super(map);
        this.cycle.add(new Turner(map, Heading.WEST));
        this.cycle.add(new Turner(map, Heading.SOUTH));
        this.cycle.add(new Turner(map, Heading.EAST));
        this.cycle.add(new Turner(map, Heading.SOUTH));
        this.cycle.add(new Turner(map, Heading.WEST));
        this.cycle.add(new Flyer(map));
        this.cycle.add(new Turner(map, Heading.NORTH));
        this.cycle.add(new Flyer(map));
        this.cycle.add(new Flyer(map));
    }

    // FIXME: Abstraction leak
    @Override
    public State getNext() {
        return new FlyNorthWestDI(map);
    }

    @Override
    public void update(JSONObject response) {
        if (step_count == 9) {
            go_next = true;
        }
    }
}