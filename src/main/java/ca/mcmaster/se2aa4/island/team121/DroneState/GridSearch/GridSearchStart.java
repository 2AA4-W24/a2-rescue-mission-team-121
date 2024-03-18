package ca.mcmaster.se2aa4.island.team121.DroneState.GridSearch;

import ca.mcmaster.se2aa4.island.team121.DroneState.State;
import ca.mcmaster.se2aa4.island.team121.Heading;
import ca.mcmaster.se2aa4.island.team121.Modules.Flyer;
import ca.mcmaster.se2aa4.island.team121.Modules.Radar;
import ca.mcmaster.se2aa4.island.team121.Modules.Scanner;
import ca.mcmaster.se2aa4.island.team121.Records.MapUpdater;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;

public class GridSearchStart extends State {

    private State next;
    private final Logger logger = LogManager.getLogger();

    public GridSearchStart(MapUpdater map) {
        super(map);
        this.cycle.add(new Scanner(map));
        this.cycle.add(new Radar(map, Heading.NORTH)); //0
        this.cycle.add(new Radar(map, Heading.SOUTH)); //1
        this.cycle.add(new Flyer(map));
    }

    @Override
    public State getNext() {
        return next;
    }

    @Override
    public void update(JSONObject response) {
        logger.info(step_count);
        // Check if we found ground from Radar
        if (parser.echoGround(response).equals("GROUND") && step_count % 4 == 2) {
            next = new TurnNorthAfterStart(map);
            go_next= true;
        } else if (parser.echoGround(response).equals("GROUND") && step_count % 4 == 3) {
            next = new TurnSouthAfterStart(map);
            go_next= true;
        }
    }
}
