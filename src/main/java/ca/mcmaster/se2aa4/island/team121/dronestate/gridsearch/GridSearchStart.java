package ca.mcmaster.se2aa4.island.team121.dronestate.gridsearch;

import ca.mcmaster.se2aa4.island.team121.businessdrivenobjects.Heading;
import ca.mcmaster.se2aa4.island.team121.dronestate.State;
import ca.mcmaster.se2aa4.island.team121.modules.Flyer;
import ca.mcmaster.se2aa4.island.team121.modules.Radar;
import ca.mcmaster.se2aa4.island.team121.modules.Scanner;
import ca.mcmaster.se2aa4.island.team121.records.MapUpdater;
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
        if ("GROUND".equals(parser.echoGround(response)) && step_count % 4 == 2) {
            next = new TurnNorthAfterStart(map);
            go_next= true;
        } else if ("GROUND".equals(parser.echoGround(response)) && step_count % 4 == 3) {
            next = new TurnSouthAfterStart(map);
            go_next= true;
        }
    }
}
