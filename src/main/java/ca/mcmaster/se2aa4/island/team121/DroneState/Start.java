package ca.mcmaster.se2aa4.island.team121.DroneState;

import ca.mcmaster.se2aa4.island.team121.Heading;
import ca.mcmaster.se2aa4.island.team121.Modules.Flyer;
import ca.mcmaster.se2aa4.island.team121.Modules.Module;
import ca.mcmaster.se2aa4.island.team121.Modules.Radar;
import ca.mcmaster.se2aa4.island.team121.Modules.Scanner;
import ca.mcmaster.se2aa4.island.team121.Records.AttributeRecord;
import ca.mcmaster.se2aa4.island.team121.Records.MapUpdater;
import ca.mcmaster.se2aa4.island.team121.TileType;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Start extends State {

    private List<Module> cycle = new ArrayList<>();
    private Module module;

    public Start(MapUpdater map, AttributeRecord drone_attributes) {
        super(map, drone_attributes);

        this.cycle.add(new Scanner());
        this.cycle.add(new Radar(Heading.SOUTH));
        this.cycle.add(new Flyer());
    }

    @Override
    public State getNext() {
        return new GoSouth(map, drone_attributes);
    }

    @Override
    public JSONObject execute() {
        module = cycle.get(step_count % cycle.size());
        step_count++;
        return module.getJSON();
    }

    @Override
    public void update(JSONObject response) {
        // Check if we found ground from Radar
        if (response.has("extras")) {
            JSONObject extras = response.getJSONObject("extras");
            if (extras.has("found")) {
                String found = extras.getString("found");
                if ("GROUND".equals(found)) {
                    go_next = true;
                }
            }
        }

        // Update map from Scanner
        if (response.has("extras")) {
            JSONObject extras = response.getJSONObject("extras");
            if(extras.has("biomes")){
                JSONArray biomes = extras.getJSONArray("biomes");
                map.updateScan(TileType.TileTypeOf(biomes.getString(0)));

            }
        }

        if (module.getClass().getSimpleName().equals("Flyer")) {
            map.updateFly();
        }
    }
}