package ca.mcmaster.se2aa4.island.team121.DroneState.DoubleInterlaced;

import ca.mcmaster.se2aa4.island.team121.DroneState.State;
import ca.mcmaster.se2aa4.island.team121.DroneState.Stop;
import ca.mcmaster.se2aa4.island.team121.Heading;
import ca.mcmaster.se2aa4.island.team121.Modules.Flyer;
import ca.mcmaster.se2aa4.island.team121.Modules.Radar;
import ca.mcmaster.se2aa4.island.team121.Modules.Turner;
import ca.mcmaster.se2aa4.island.team121.Records.AttributeRecord;
import ca.mcmaster.se2aa4.island.team121.Records.MapUpdater;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;

import java.util.Objects;

public class North2SouthUTurnEastDI extends State {
    private State next;
    private final Logger logger = LogManager.getLogger();

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
        if (init_scan_heading == Heading.EAST) {
            if (Objects.equals(parser.echoGround(response), "OUT_OF_RANGE"))
                next = new TurnBackSouthWest(map);
            else {
                next = new FlySouthEastDI(map);
            }
        }
        else if (init_scan_heading == Heading.WEST){
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