package ca.mcmaster.se2aa4.island.team121.DroneState.GridSearch;

import ca.mcmaster.se2aa4.island.team121.DroneState.State;
import ca.mcmaster.se2aa4.island.team121.Heading;
import ca.mcmaster.se2aa4.island.team121.Modules.Flyer;
import ca.mcmaster.se2aa4.island.team121.Modules.Radar;
import ca.mcmaster.se2aa4.island.team121.Modules.Scanner;
import ca.mcmaster.se2aa4.island.team121.Records.AttributeRecord;
import ca.mcmaster.se2aa4.island.team121.Records.MapUpdater;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;

public class GridSearchStart extends State {

    private final Logger logger = LogManager.getLogger();

    public GridSearchStart(MapUpdater map, AttributeRecord drone_attributes) {
        super(map, drone_attributes);
        this.cycle.add(new Scanner(map));
        this.cycle.add(new Radar(map, Heading.SOUTH));
        this.cycle.add(new Flyer(map));
    }

    @Override
    public State getNext() {
        return new TurnSouthAfterStart(map, drone_attributes);
    }

    @Override
    public void update(JSONObject response) {
        // Check if we found ground from Radar
        if(parser.echoGround(response).equals("GROUND")) {
            go_next = true;
        }

        // Update map from Scanner
        map.updateScan(parser.getScan(response));
    }
}
