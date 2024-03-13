package ca.mcmaster.se2aa4.island.team121.DroneState;

import ca.mcmaster.se2aa4.island.team121.DroneState.JSONParser.JSONParser;
import ca.mcmaster.se2aa4.island.team121.DroneState.JSONParser.DefaultJSONParser;
import ca.mcmaster.se2aa4.island.team121.Modules.Module;
import ca.mcmaster.se2aa4.island.team121.Records.AttributeRecord;
import ca.mcmaster.se2aa4.island.team121.Records.MapUpdater;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public abstract class State {

    protected int step_count = 0;
    protected boolean go_next = false;
    protected MapUpdater map;
    protected AttributeRecord drone_attributes;
    protected JSONParser parser = new DefaultJSONParser();
    protected List<Module> cycle = new ArrayList<>();
    protected Module module;


    public State(MapUpdater map, AttributeRecord drone_attributes) {
        this.map = map;
        this.drone_attributes = drone_attributes;
    }

    // FIXME: This is an abstraction leak
    public boolean isGoNext() {
        return go_next;
    }

    public JSONObject execute() {
        module = cycle.get(step_count % cycle.size());
        module.updateMap();
        step_count++;
        return module.getJSON();
    }

    public abstract State getNext();
    public abstract void update(JSONObject json);
}
