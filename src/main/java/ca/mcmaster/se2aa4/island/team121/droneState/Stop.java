package ca.mcmaster.se2aa4.island.team121.droneState;

import ca.mcmaster.se2aa4.island.team121.Modules.Stopper;
import ca.mcmaster.se2aa4.island.team121.Records.MapUpdater;
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
