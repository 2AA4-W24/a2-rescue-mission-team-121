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

    private final Logger logger = LogManager.getLogger();

    public GridSearchStartDI(MapUpdater map) {
        super(map);
        this.cycle.add(new Radar(map, Heading.SOUTH));
        this.cycle.add(new Flyer(map));
    }

    @Override
    public State getNext() {
        return new TurnSouthAfterStartDI(map);
    }

    @Override
    public void update(JSONObject response) {
        if(parser.echoGround(response).equals("GROUND")) {
            go_next = true;
        }
    }
}