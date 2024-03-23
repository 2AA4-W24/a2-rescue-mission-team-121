package ca.mcmaster.se2aa4.island.team121.droneState.doubleInterlaced;

import ca.mcmaster.se2aa4.island.team121.Heading;
import ca.mcmaster.se2aa4.island.team121.Modules.Radar;
import ca.mcmaster.se2aa4.island.team121.Modules.Turner;
import ca.mcmaster.se2aa4.island.team121.Records.MapUpdater;
import ca.mcmaster.se2aa4.island.team121.droneState.State;
import ca.mcmaster.se2aa4.island.team121.droneState.Stop;
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
            if (Objects.equals(parser.echoGround(response), "OUT_OF_RANGE"))
                next = new Stop(map);
            else {
                next = new FlyNorthWestDI(map);
            }
        }
        else if (map.getScanHeading() == Heading.WEST){
            if (Objects.equals(parser.echoGround(response), "OUT_OF_RANGE"))
                next = new TurnBackNorthEast(map);
            else {
                next = new FlyNorthWestDI(map);
            }
        }
        if (step_count == 3) {
            go_next = true;
        }
    }
}
