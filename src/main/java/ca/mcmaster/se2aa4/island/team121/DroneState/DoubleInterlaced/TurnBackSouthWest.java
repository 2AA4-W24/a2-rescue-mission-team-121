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

public class TurnBackSouthWest extends State {

    private State next;
    private final Logger logger = LogManager.getLogger();

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