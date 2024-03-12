package ca.mcmaster.se2aa4.island.team121.DroneState;

import ca.mcmaster.se2aa4.island.team121.DroneState.JSONParser.JSONParser;
import ca.mcmaster.se2aa4.island.team121.DroneState.JSONParser.DefaultJSONParser;
import ca.mcmaster.se2aa4.island.team121.Records.AttributeRecord;
import ca.mcmaster.se2aa4.island.team121.Records.MapUpdater;
import org.json.JSONObject;

public abstract class State {

    protected int step_count = 0;
    protected boolean go_next = false;
    protected State next;
    protected MapUpdater map;
    protected AttributeRecord drone_attributes;
    protected JSONParser parser = new DefaultJSONParser();

    public State(MapUpdater map, AttributeRecord drone_attributes) {
        this.map = map;
        this.drone_attributes = drone_attributes;
    }

    // FIXME: This is an abstraction leak
    public boolean isGoNext() {
        return go_next;
    }

    public abstract State getNext();
    public abstract JSONObject execute();
    public abstract void update(JSONObject json);
}
