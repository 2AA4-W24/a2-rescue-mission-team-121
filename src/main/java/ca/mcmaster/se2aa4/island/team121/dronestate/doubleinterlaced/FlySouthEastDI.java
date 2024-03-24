package ca.mcmaster.se2aa4.island.team121.dronestate.doubleinterlaced;

import ca.mcmaster.se2aa4.island.team121.businessdrivenobjects.Heading;
import ca.mcmaster.se2aa4.island.team121.businessdrivenobjects.TileRecord;
import ca.mcmaster.se2aa4.island.team121.dronestate.State;
import ca.mcmaster.se2aa4.island.team121.modules.Flyer;
import ca.mcmaster.se2aa4.island.team121.modules.Radar;
import ca.mcmaster.se2aa4.island.team121.modules.Scanner;
import ca.mcmaster.se2aa4.island.team121.records.MapUpdater;
import org.json.JSONObject;

import java.util.Objects;

public class FlySouthEastDI extends State {

    public FlySouthEastDI(MapUpdater map) {
        super(map);
        this.cycle.add(new Scanner(map));
        this.cycle.add(new Flyer(map));
        this.cycle.add(new Radar(map, Heading.SOUTH));
    }

    @Override
    public State getNext(){
        return new South2NorthUTurnEastDI(map);
    }

    @Override
    public void update(JSONObject response){
        TileRecord tile = new TileRecord(parser.getScan(response),parser.getId(response));
        map.updateScan(tile);
        go_next= Objects.equals("OUT_OF_RANGE",parser.echoGround(response));
    }
}
