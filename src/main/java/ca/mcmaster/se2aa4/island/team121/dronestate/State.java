package ca.mcmaster.se2aa4.island.team121.dronestate;

import ca.mcmaster.se2aa4.island.team121.businessdrivenobjects.Heading;
import ca.mcmaster.se2aa4.island.team121.jsonparser.DefaultJSONParser;
import ca.mcmaster.se2aa4.island.team121.jsonparser.JSONParser;
import ca.mcmaster.se2aa4.island.team121.modules.Module;
import ca.mcmaster.se2aa4.island.team121.records.MapUpdater;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public abstract class State {

    protected int step_count = 0;
    protected boolean go_next = false;
    protected JSONParser parser = new DefaultJSONParser();
    protected List<Module> cycle = new ArrayList<>();
    protected MapUpdater map;
    protected Module module;
    protected Heading scan_heading;

    public State(MapUpdater map) {
        this.map = map;
        this.scan_heading = map.getScanHeading();
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
