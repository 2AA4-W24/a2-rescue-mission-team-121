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
import java.util.Objects;

public class FlyNorth extends State {

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
    public void update(JSONObject response){
        map.updateScan(parser.getScan(response));
        go_next= Objects.equals(parser.echoGround(response), "OUT_OF_RANGE");
        if (module.getClass().getSimpleName().equals("Flyer")) {
            map.updateFly();
        }
    }
}
