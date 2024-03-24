package ca.mcmaster.se2aa4.island.team121.dronestate.doubleinterlaced;

import ca.mcmaster.se2aa4.island.team121.dronestate.State;
import ca.mcmaster.se2aa4.island.team121.businessdrivenobjects.Heading;
import ca.mcmaster.se2aa4.island.team121.modules.Flyer;
import ca.mcmaster.se2aa4.island.team121.modules.Turner;
import ca.mcmaster.se2aa4.island.team121.records.MapUpdater;
import org.json.JSONObject;

public class TurnBackSouthWest extends State {
    public TurnBackSouthWest(MapUpdater map) {
        super(map);
        this.cycle.add(new Turner(map, Heading.WEST));
        this.cycle.add(new Turner(map, Heading.NORTH));
        this.cycle.add(new Turner(map, Heading.EAST));
        this.cycle.add(new Turner(map, Heading.NORTH));
        this.cycle.add(new Turner(map, Heading.WEST));
        this.cycle.add(new Flyer(map));
        this.cycle.add(new Turner(map, Heading.SOUTH));
        this.cycle.add(new Flyer(map));
        this.cycle.add(new Flyer(map));
    }

    // FIXME: Abstraction leak
    @Override
    public State getNext() {
        return new FlySouthWestDI(map);
    }

    @Override
    public void update(JSONObject response) {

        if (step_count == 9) {
            go_next = true;
        }
    }
}