package ca.mcmaster.se2aa4.island.team121.DroneState;

import ca.mcmaster.se2aa4.island.team121.DroneState.GridSearch.FlySouth;
import ca.mcmaster.se2aa4.island.team121.DroneState.State;
import ca.mcmaster.se2aa4.island.team121.Modules.Flyer;
import ca.mcmaster.se2aa4.island.team121.Modules.Scanner;
import ca.mcmaster.se2aa4.island.team121.Records.AttributeRecord;
import ca.mcmaster.se2aa4.island.team121.Records.MapUpdater;
import org.json.JSONObject;

public class FlyStraight extends State {

    private int flight_length;

    public FlyStraight(MapUpdater map, AttributeRecord drone_attributes, int dist) {
        super(map, drone_attributes);
        this.cycle.add(new Flyer(map));
        flight_length = dist;
    }

    @Override
    public State getNext(){
        return new FlySouth(map, drone_attributes);
    }

    @Override
    public void update(JSONObject response){
        map.updateScan((parser.getScan(response)));

        if (step_count == flight_length-1)
            go_next = true;
    }
}
