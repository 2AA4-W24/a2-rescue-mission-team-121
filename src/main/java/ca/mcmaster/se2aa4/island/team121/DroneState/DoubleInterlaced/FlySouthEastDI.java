package ca.mcmaster.se2aa4.island.team121.DroneState.DoubleInterlaced;

import ca.mcmaster.se2aa4.island.team121.DroneState.State;
import ca.mcmaster.se2aa4.island.team121.Heading;
import ca.mcmaster.se2aa4.island.team121.Modules.Flyer;
import ca.mcmaster.se2aa4.island.team121.Modules.Radar;
import ca.mcmaster.se2aa4.island.team121.Modules.Scanner;
import ca.mcmaster.se2aa4.island.team121.Records.MapUpdater;
import ca.mcmaster.se2aa4.island.team121.TileRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;

import java.util.Objects;

public class FlySouthEastDI extends State {
    private final Logger logger = LogManager.getLogger();
    public FlySouthEastDI(MapUpdater map) {
        super(map);
        this.cycle.add(new Flyer(map));
        this.cycle.add(new Scanner(map));
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
        go_next= Objects.equals(parser.echoGround(response), "OUT_OF_RANGE");
    }
}