package ca.mcmaster.se2aa4.island.team121.DroneState.DoubleInterlaced;

import ca.mcmaster.se2aa4.island.team121.DroneState.State;
import ca.mcmaster.se2aa4.island.team121.DroneState.Stop;
import ca.mcmaster.se2aa4.island.team121.BusinessDrivenObjects.Heading;
import ca.mcmaster.se2aa4.island.team121.Modules.Radar;
import ca.mcmaster.se2aa4.island.team121.Modules.Turner;
import ca.mcmaster.se2aa4.island.team121.Records.MapUpdater;
import org.json.JSONObject;

import java.util.Objects;

public class North2SouthUTurnEastDI extends State {
    private State next;

    public North2SouthUTurnEastDI(MapUpdater map) {
        super(map);
        this.cycle.add(new Turner(map, Heading.EAST));
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
            if (Objects.equals(parser.echoGround(response), "OUT_OF_RANGE"))
                next = new TurnBackSouthWest(map);
            else {
                next = new FlySouthEastDI(map);
            }
        }
        else if (map.getScanHeading() == Heading.WEST){
            if (Objects.equals(parser.echoGround(response), "OUT_OF_RANGE"))
                next = new Stop(map);
            else {
                next = new FlySouthEastDI(map);
            }
        }
        if (step_count == 3) {
            go_next = true;
        }
    }
}