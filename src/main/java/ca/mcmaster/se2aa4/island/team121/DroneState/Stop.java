package ca.mcmaster.se2aa4.island.team121.DroneState;

import ca.mcmaster.se2aa4.island.team121.Modules.*;
import ca.mcmaster.se2aa4.island.team121.Modules.Module;
import ca.mcmaster.se2aa4.island.team121.Records.AttributeRecord;
import ca.mcmaster.se2aa4.island.team121.Records.MapUpdater;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Stop extends State {

    private List<Module> cycle = new ArrayList<>();
    private Module module;

    public Stop(MapUpdater map, AttributeRecord drone_attributes) {
        super(map, drone_attributes);

        this.cycle.add(new Stopper());
    }
    @Override
    public State getNext() {
        // Does not have a next
        return null;
    }

    @Override
    public JSONObject execute() {
        module = cycle.get(step_count % cycle.size());
        step_count++;
        return module.getJSON();
    }

    @Override
    public void update(JSONObject json) {
        // Do nothing
    }
}