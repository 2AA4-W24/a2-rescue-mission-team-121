package ca.mcmaster.se2aa4.island.team121.DroneState.GridSearch;

import ca.mcmaster.se2aa4.island.team121.DroneState.State;
import ca.mcmaster.se2aa4.island.team121.Heading;
import ca.mcmaster.se2aa4.island.team121.Modules.Flyer;
import ca.mcmaster.se2aa4.island.team121.Modules.Module;
import ca.mcmaster.se2aa4.island.team121.Modules.Scanner;
import ca.mcmaster.se2aa4.island.team121.Modules.Radar;
import ca.mcmaster.se2aa4.island.team121.Records.AttributeRecord;
import ca.mcmaster.se2aa4.island.team121.Records.MapUpdater;
import ca.mcmaster.se2aa4.island.team121.TileType;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class FlyNorth extends State {
    private List<Module> cycle = new ArrayList<>();
    private Module module;


    public FlyNorth(MapUpdater map, AttributeRecord drone_attributes) {
        super(map, drone_attributes);
        this.cycle.add(new Flyer());
        this.cycle.add(new Scanner());
        this.cycle.add(new Radar(Heading.NORTH));
    }

    @Override
    public State getNext(){
        return new North2SouthEast(map, drone_attributes);
    }

    @Override
    public JSONObject execute() {
        module = cycle.get(step_count % cycle.size());
        step_count++;
        return module.getJSON();
    }

    @Override
    public void update(JSONObject response){
        map.updateScan(parser.getScan(response));
        go_next= parser.echoGround(response);
        if (module.getClass().getSimpleName().equals("Flyer")) {
            map.updateFly();
        }
    }
}
