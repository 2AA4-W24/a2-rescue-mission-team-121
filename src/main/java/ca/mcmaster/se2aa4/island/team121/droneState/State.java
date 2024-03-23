package ca.mcmaster.se2aa4.island.team121.droneState;

import ca.mcmaster.se2aa4.island.team121.Heading;
import ca.mcmaster.se2aa4.island.team121.Modules.Module;
import ca.mcmaster.se2aa4.island.team121.Records.MapUpdater;
import ca.mcmaster.se2aa4.island.team121.droneState.JSONParser.DefaultJSONParser;
import ca.mcmaster.se2aa4.island.team121.droneState.JSONParser.JSONParser;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public abstract class State {

    protected int step_count = 0;
    protected boolean go_next = false;
    protected final JSONParser parser = new DefaultJSONParser();
    protected final List<Module> cycle = new ArrayList<>();
    protected final MapUpdater map;
    protected Module module;
    protected final Heading scan_heading;

    protected State(MapUpdater map) {
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
