package ca.mcmaster.se2aa4.island.team121.DroneState.ProgressiveScan;

import ca.mcmaster.se2aa4.island.team121.DroneState.State;
import ca.mcmaster.se2aa4.island.team121.Modules.Flyer;
import ca.mcmaster.se2aa4.island.team121.Records.MapUpdater;
import ca.mcmaster.se2aa4.island.team121.TileRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;

public class FlyStraight extends State {

    private int flight_length;
    private final Logger logger = LogManager.getLogger();

    public FlyStraight(MapUpdater map, int dist) {
        super(map);
        this.cycle.add(new Flyer(map));
        flight_length = dist;
    }

    @Override
    public State getNext(){
        return new FlySouth(map);
    }

    @Override
    public void update(JSONObject response){
        TileRecord tile = new TileRecord(parser.getScan(response),parser.getId(response));
        map.updateScan(tile);

        if (step_count == flight_length-1) {
            go_next = true;
        }
    }
}
