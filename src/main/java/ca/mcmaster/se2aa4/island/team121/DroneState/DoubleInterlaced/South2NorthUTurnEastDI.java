package ca.mcmaster.se2aa4.island.team121.DroneState.DoubleInterlaced;

import ca.mcmaster.se2aa4.island.team121.DroneState.GridSearch.FlyNorth;
import ca.mcmaster.se2aa4.island.team121.DroneState.State;
import ca.mcmaster.se2aa4.island.team121.DroneState.Stop;
import ca.mcmaster.se2aa4.island.team121.Heading;
import ca.mcmaster.se2aa4.island.team121.Modules.Radar;
import ca.mcmaster.se2aa4.island.team121.Modules.Turner;
import ca.mcmaster.se2aa4.island.team121.Records.AttributeRecord;
import ca.mcmaster.se2aa4.island.team121.Records.MapUpdater;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;

import java.util.Objects;

public class South2NorthUTurnEastDI extends State {
    private State next;
    private final Logger logger = LogManager.getLogger();
    public South2NorthUTurnEastDI(MapUpdater map, AttributeRecord drone_attributes) {
        super(map, drone_attributes);
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
        next = ((Objects.equals(parser.echoGround(response), "OUT_OF_RANGE")) ? new TurnBackNorthWest(map, drone_attributes) : new FlyNorthEastDI(map, drone_attributes));
        if (step_count == 3) {
            go_next = true;
        }
    }
}
