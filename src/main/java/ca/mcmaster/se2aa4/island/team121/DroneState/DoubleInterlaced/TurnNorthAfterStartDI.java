package ca.mcmaster.se2aa4.island.team121.DroneState.DoubleInterlaced;

import ca.mcmaster.se2aa4.island.team121.DroneState.State;
import ca.mcmaster.se2aa4.island.team121.Heading;
import ca.mcmaster.se2aa4.island.team121.Modules.Radar;
import ca.mcmaster.se2aa4.island.team121.Modules.Turner;
import ca.mcmaster.se2aa4.island.team121.Records.MapUpdater;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;

public class TurnNorthAfterStartDI extends State {

    private final Logger logger = LogManager.getLogger();
    private int dist = 0;

    public TurnNorthAfterStartDI(MapUpdater map) {
        super(map);
        this.cycle.add(new Turner(map, Heading.NORTH));
        this.cycle.add(new Radar(map, Heading.NORTH));
    }

    @Override
    public State getNext() {
        return new FlyStraightDI(map, dist, Heading.NORTH);
    }

    @Override
    public void update(JSONObject response) {
        if (parser.echoGround(response).equals("GROUND")) {
            dist = parser.echoDistance(response);
            logger.info(dist);
        }
        if (step_count == 2)
            go_next = true;
    }
}
