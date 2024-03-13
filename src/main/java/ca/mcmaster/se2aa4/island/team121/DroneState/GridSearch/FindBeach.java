package ca.mcmaster.se2aa4.island.team121.DroneState.GridSearch;

import ca.mcmaster.se2aa4.island.team121.DroneState.State;
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

    public FindBeach(MapUpdater map, AttributeRecord drone_attributes) {
        super(map, drone_attributes);
        this.cycle.add(new Flyer());
    }

    @Override
    public State getNext(){
        return new FlySouth(map, drone_attributes);
    }

    @Override
    public void update(JSONObject response){
        map.updateScan((parser.getScan(response)));

        if (step_count==GridSearchStart.dist-1)
            go_next =true;

    }
}
