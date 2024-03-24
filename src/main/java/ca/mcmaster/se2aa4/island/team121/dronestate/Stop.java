package ca.mcmaster.se2aa4.island.team121.dronestate;

import ca.mcmaster.se2aa4.island.team121.modules.Stopper;
import ca.mcmaster.se2aa4.island.team121.records.MapUpdater;
import org.json.JSONObject;

public class Stop extends State {

    public Stop(MapUpdater map) {
        super(map);
        this.cycle.add(new Stopper(map));
    }
    @Override
    public State getNext() {
        // Does not have a next
        return null;
    }

    @Override
    public void update(JSONObject json) {
        // Do nothing
    }
}
