package ca.mcmaster.se2aa4.island.team121.dronestate.doubleinterlaced;

import ca.mcmaster.se2aa4.island.team121.businessdrivenobjects.Heading;
import ca.mcmaster.se2aa4.island.team121.dronestate.State;
import ca.mcmaster.se2aa4.island.team121.modules.Radar;
import ca.mcmaster.se2aa4.island.team121.modules.Turner;
import ca.mcmaster.se2aa4.island.team121.records.MapUpdater;
import org.json.JSONObject;

public class TurnAfterNorthSouthCheckDI extends State {
    private Heading heading;

    public TurnAfterNorthSouthCheckDI(MapUpdater map) {
        super(map);
        this.heading=map.getScanHeading();
        this.cycle.add(new Turner(map, heading));
        this.cycle.add(new Radar(map, heading));
    }

    @Override
    public State getNext() {
        return new GridSearchStartDI(map);
    }

    @Override
    public void update(JSONObject response) {
        if (step_count == 2) {
            go_next = true;
        }
    }
}
