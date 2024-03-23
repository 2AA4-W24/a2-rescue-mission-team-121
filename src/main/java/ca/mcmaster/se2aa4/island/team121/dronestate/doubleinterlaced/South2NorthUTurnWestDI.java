package ca.mcmaster.se2aa4.island.team121.dronestate.doubleinterlaced;

import ca.mcmaster.se2aa4.island.team121.Heading;
import ca.mcmaster.se2aa4.island.team121.modules.Radar;
import ca.mcmaster.se2aa4.island.team121.modules.Turner;
import ca.mcmaster.se2aa4.island.team121.records.MapUpdater;
import ca.mcmaster.se2aa4.island.team121.dronestate.State;
import ca.mcmaster.se2aa4.island.team121.dronestate.Stop;
import org.json.JSONObject;

import java.util.Objects;

public class South2NorthUTurnWestDI extends State{
    private State next;
    public South2NorthUTurnWestDI(MapUpdater map) {
        super(map);
        this.cycle.add(new Turner(map, Heading.WEST));
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
        if (map.getScanHeading() == Heading.EAST) {
            if (Objects.equals("OUT_OF_RANGE",parser.echoGround(response))) {
                next = new Stop(map);
            }
            else {
                next = new FlyNorthWestDI(map);
            }
        }
        else if (map.getScanHeading() == Heading.WEST){
            if (Objects.equals("OUT_OF_RANGE",parser.echoGround(response))) {
                next = new TurnBackNorthEast(map);
            }
            else {
                next = new FlyNorthWestDI(map);
            }
        }
        if (step_count == 3) {
            go_next = true;
        }
    }
}
