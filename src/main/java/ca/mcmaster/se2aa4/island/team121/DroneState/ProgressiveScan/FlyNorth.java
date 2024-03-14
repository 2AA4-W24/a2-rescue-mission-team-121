package ca.mcmaster.se2aa4.island.team121.DroneState.ProgressiveScan;

import ca.mcmaster.se2aa4.island.team121.DroneState.State;
import ca.mcmaster.se2aa4.island.team121.Heading;
import ca.mcmaster.se2aa4.island.team121.Modules.Flyer;
import ca.mcmaster.se2aa4.island.team121.Modules.Radar;
import ca.mcmaster.se2aa4.island.team121.Modules.Scanner;
import ca.mcmaster.se2aa4.island.team121.Records.AttributeRecord;
import ca.mcmaster.se2aa4.island.team121.Records.MapUpdater;
import ca.mcmaster.se2aa4.island.team121.TileRecord;
import org.json.JSONObject;

import java.util.Objects;


public class FlyNorth extends State {
    public FlyNorth(MapUpdater map, AttributeRecord drone_attributes) {
        super(map, drone_attributes);
        this.cycle.add(new Flyer(map));
        this.cycle.add(new Scanner(map));
        this.cycle.add(new Radar(map, Heading.NORTH));
    }

    @Override
    public State getNext(){
        return new North2SouthProg(map, drone_attributes);
    }

    @Override
    public void update(JSONObject response){
        TileRecord tile = new TileRecord(parser.getScan(response),parser.getId(response));
        if (module.getClass().getSimpleName().equals("Scanner")) {
            map.updateScan(tile);
        }

        go_next= Objects.equals(parser.echoGround(response), "OUT_OF_RANGE");
    }
}
