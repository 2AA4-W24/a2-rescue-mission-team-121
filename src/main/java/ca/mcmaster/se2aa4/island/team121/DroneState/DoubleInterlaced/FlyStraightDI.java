package ca.mcmaster.se2aa4.island.team121.DroneState.DoubleInterlaced;

import ca.mcmaster.se2aa4.island.team121.DroneState.State;
import ca.mcmaster.se2aa4.island.team121.BusinessDrivenObjects.Heading;
import ca.mcmaster.se2aa4.island.team121.Modules.Flyer;
import ca.mcmaster.se2aa4.island.team121.Records.MapUpdater;
import ca.mcmaster.se2aa4.island.team121.BusinessDrivenObjects.TileRecord;
import org.json.JSONObject;

public class FlyStraightDI extends State {

    private int flight_length;
    private Heading heading;
    private State next;

    public FlyStraightDI(MapUpdater map, int dist, Heading heading) {
        super(map);
        this.cycle.add(new Flyer(map));
        this.flight_length = dist;
        this.heading = heading;
    }

    @Override
    public State getNext(){
        return next;
    }

    @Override
    public void update(JSONObject response){
        TileRecord tile = new TileRecord(parser.getScan(response),parser.getId(response));
        map.updateScan(tile);

        if (step_count == flight_length+1) {
            if (heading == Heading.NORTH) {
                if (map.getScanHeading() == Heading.EAST) {
                    next = new FlyNorthEastDI(map);
                }
                else{
                    next = new FlyNorthWestDI(map);
                }
            }
            else if (heading == Heading.SOUTH){
                if (map.getScanHeading()==Heading.EAST){
                    next = new FlySouthEastDI(map);
                }
                else {
                    next= new FlySouthWestDI(map);
                }
            }
            go_next = true;
        }
    }
}
