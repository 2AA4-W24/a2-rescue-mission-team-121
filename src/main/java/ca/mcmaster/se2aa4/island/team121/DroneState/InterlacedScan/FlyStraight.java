package ca.mcmaster.se2aa4.island.team121.DroneState.InterlacedScan;

import ca.mcmaster.se2aa4.island.team121.DroneState.State;
import ca.mcmaster.se2aa4.island.team121.Modules.Flyer;
import ca.mcmaster.se2aa4.island.team121.Records.AttributeRecord;
import ca.mcmaster.se2aa4.island.team121.Records.MapUpdater;
import ca.mcmaster.se2aa4.island.team121.TileRecord;
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
        TileRecord tile = new TileRecord(parser.getScan(response),parser.getId(response));
        map.updateScan(tile);

        if (step_count == flight_length-1)
            go_next = true;
    }
}
