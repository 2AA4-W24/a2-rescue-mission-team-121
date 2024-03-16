package ca.mcmaster.se2aa4.island.team121.DroneState.DoubleInterlaced;

import ca.mcmaster.se2aa4.island.team121.DroneState.State;
import ca.mcmaster.se2aa4.island.team121.Heading;
import ca.mcmaster.se2aa4.island.team121.Modules.Flyer;
import ca.mcmaster.se2aa4.island.team121.Modules.Radar;
import ca.mcmaster.se2aa4.island.team121.Modules.Scanner;
import ca.mcmaster.se2aa4.island.team121.Records.AttributeRecord;
import ca.mcmaster.se2aa4.island.team121.Records.MapUpdater;
import ca.mcmaster.se2aa4.island.team121.TileRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;

public class GridSearchStartDI extends State {

    private State next;
    private final Logger logger = LogManager.getLogger();



    public GridSearchStartDI(MapUpdater map, Heading scan_dir) {
        super(map);
        init_scan_heading=scan_dir;
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
        // Check if we found ground from Radar
        logger.info(init_scan_heading.toString());
        if (parser.echoGround(response).equals("GROUND") && step_count % 3 == 1) {
            next = new TurnNorthAfterStartDI(map);
            go_next= true;
        } else if (parser.echoGround(response).equals("GROUND") && step_count % 3 == 2) {
            next = new TurnSouthAfterStartDI(map);
            go_next= true;
        }
    }
}