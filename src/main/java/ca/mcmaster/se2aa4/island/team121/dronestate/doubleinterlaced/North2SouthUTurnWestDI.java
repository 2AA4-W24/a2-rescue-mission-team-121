package ca.mcmaster.se2aa4.island.team121.dronestate.doubleinterlaced;

import ca.mcmaster.se2aa4.island.team121.businessdrivenobjects.Heading;
import ca.mcmaster.se2aa4.island.team121.dronestate.State;
import ca.mcmaster.se2aa4.island.team121.dronestate.Stop;
import ca.mcmaster.se2aa4.island.team121.modules.Radar;
import ca.mcmaster.se2aa4.island.team121.modules.Turner;
import ca.mcmaster.se2aa4.island.team121.records.MapUpdater;
import org.json.JSONObject;

import java.util.Objects;

public class North2SouthUTurnWestDI extends State {
    private State next;

    public North2SouthUTurnWestDI(MapUpdater map) {
        super(map);
        this.cycle.add(new Turner(map, Heading.WEST));
        this.cycle.add(new Turner(map, Heading.SOUTH));
        this.cycle.add(new Radar(map, Heading.SOUTH));
    }

    // FIXME: Abstraction leak
    @Override
    public State getNext() {
        return next;
    }

    @Override
    public void update(JSONObject response) {
        if (map.getScanHeading() == Heading.EAST) {
            if (Objects.equals("OUT_OF_RANGE",parser.echoGround(response))) {
                next = new Stop(map);
            }
            else {
                next = new FlySouthWestDI(map);
            }
        }
        else if (map.getScanHeading() == Heading.WEST){
            if (Objects.equals(parser.echoGround(response), "OUT_OF_RANGE")) {
                next = new TurnBackSouthEast(map);
            }
            else {
                next = new FlySouthWestDI(map);
            }
        }

        if (step_count == 3) {
            go_next = true;
        }

    }
}