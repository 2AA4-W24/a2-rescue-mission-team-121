package ca.mcmaster.se2aa4.island.team121.droneState.GridSearch;

import ca.mcmaster.se2aa4.island.team121.Heading;
import ca.mcmaster.se2aa4.island.team121.Modules.Flyer;
import ca.mcmaster.se2aa4.island.team121.Modules.Radar;
import ca.mcmaster.se2aa4.island.team121.Modules.Scanner;
import ca.mcmaster.se2aa4.island.team121.Records.MapUpdater;
import ca.mcmaster.se2aa4.island.team121.TileRecord;
import ca.mcmaster.se2aa4.island.team121.droneState.State;
import org.json.JSONObject;

import java.util.Objects;

public class FlySouth extends State {
    public FlySouth(MapUpdater map) {
        super(map);
        this.cycle.add(new Flyer(map));
        this.cycle.add(new Scanner(map));
        this.cycle.add(new Radar(map, Heading.SOUTH));
    }

    @Override
    public State getNext(){
        return new South2NorthProg(map);
    }

    @Override
    public void update(JSONObject response){
        TileRecord tile = new TileRecord(parser.getScan(response),parser.getId(response));
        if (module.getClass().getSimpleName().equals("Scanner")) { // Only update the map if the module is a scanner
            map.updateScan(tile);
        }

        go_next= Objects.equals(parser.echoGround(response), "OUT_OF_RANGE");
    }
}
