package ca.mcmaster.se2aa4.island.team121.DroneState.DoubleInterlaced;

import ca.mcmaster.se2aa4.island.team121.DroneState.State;
import ca.mcmaster.se2aa4.island.team121.Heading;
import ca.mcmaster.se2aa4.island.team121.Modules.Radar;
import ca.mcmaster.se2aa4.island.team121.Modules.Turner;
import ca.mcmaster.se2aa4.island.team121.Records.MapUpdater;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;

public class TurnAfterNorthSouthCheckDI extends State {

    private final Logger logger = LogManager.getLogger();
    private Heading heading;
    public TurnAfterNorthSouthCheckDI(MapUpdater map, Heading heading) {
        super(map);
        this.heading=heading;
        this.cycle.add(new Turner(map, heading));
        this.cycle.add(new Radar(map, heading));
    }

    @Override
    public State getNext() {
        return new GridSearchStartDI(map, heading);
    }

    @Override
    public void update(JSONObject response) {
        if (step_count == 2)
            go_next = true;
    }
}
