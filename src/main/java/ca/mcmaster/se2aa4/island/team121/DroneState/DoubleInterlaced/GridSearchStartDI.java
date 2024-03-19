package ca.mcmaster.se2aa4.island.team121.DroneState.DoubleInterlaced;

import ca.mcmaster.se2aa4.island.team121.DroneState.State;
import ca.mcmaster.se2aa4.island.team121.Heading;
import ca.mcmaster.se2aa4.island.team121.Modules.Flyer;
import ca.mcmaster.se2aa4.island.team121.Modules.Radar;
import ca.mcmaster.se2aa4.island.team121.Records.MapUpdater;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;

public class GridSearchStartDI extends State {

    private State next;
    private final Logger logger = LogManager.getLogger();

    public GridSearchStartDI(MapUpdater map) {
        super(map);
        this.cycle.add(new Radar(map, Heading.NORTH)); //1
        this.cycle.add(new Radar(map, Heading.SOUTH)); //2
        this.cycle.add(new Flyer(map));
    }

    @Override
    public State getNext() {
        return next;
    }

    @Override
    public void update(JSONObject response) {
        // Check if we found ground from Radar
        if (parser.echoGround(response).equals("GROUND") && step_count % 3 == 1) {
            next = new TurnAfterStartDI(map, Heading.NORTH);
            go_next= true;
        } else if (parser.echoGround(response).equals("GROUND") && step_count % 3 == 2) {
            next = new TurnAfterStartDI(map, Heading.SOUTH);
            go_next= true;
        }
    }
}