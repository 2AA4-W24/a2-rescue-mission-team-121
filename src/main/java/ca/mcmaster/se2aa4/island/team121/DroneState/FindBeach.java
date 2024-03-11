package ca.mcmaster.se2aa4.island.team121.DroneState;

import ca.mcmaster.se2aa4.island.team121.Modules.Flyer;
import ca.mcmaster.se2aa4.island.team121.Modules.Module;
import ca.mcmaster.se2aa4.island.team121.Modules.Scanner;
import ca.mcmaster.se2aa4.island.team121.Records.AttributeRecord;
import ca.mcmaster.se2aa4.island.team121.Records.MapUpdater;
import org.json.JSONObject;
import org.json.JSONArray;
import ca.mcmaster.se2aa4.island.team121.TileType;

import java.util.ArrayList;
import java.util.List;

public class FindBeach extends State {

    private List<Module> cycle = new ArrayList<>();
    private Module module;

    public FindBeach(MapUpdater map, AttributeRecord drone_attributes) {
        super(map, drone_attributes);
        this.cycle.add(new Scanner());
        this.cycle.add(new Flyer());
    }

    @Override
    public void update(JSONObject response){
        if (response.has("extras")) {
           JSONObject extras = response.getJSONObject("extras");
           if(extras.has("biomes")){
               JSONArray biomes = extras.getJSONArray("biomes");
                map.updateScan(TileType.TileTypeOf(biomes.getString(0)));
           }
           if (map.isOverGound())
           {
               go_next =true;
           }
        }
    }

    @Override
    public JSONObject execute() {
        module = cycle.get(step_count % cycle.size());
        step_count++;
        return module.getJSON();
    }
    @Override
    public State getNext(){
        return new FlySouth(map, drone_attributes);
    }
}
