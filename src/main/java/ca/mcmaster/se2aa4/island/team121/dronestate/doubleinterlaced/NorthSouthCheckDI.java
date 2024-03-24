package ca.mcmaster.se2aa4.island.team121.dronestate.doubleinterlaced;

import ca.mcmaster.se2aa4.island.team121.dronestate.State;
import ca.mcmaster.se2aa4.island.team121.businessdrivenobjects.Heading;
import ca.mcmaster.se2aa4.island.team121.modules.Flyer;
import ca.mcmaster.se2aa4.island.team121.modules.Radar;
import ca.mcmaster.se2aa4.island.team121.records.MapUpdater;
import org.json.JSONObject;

public class NorthSouthCheckDI extends State {

    private State next;

    public NorthSouthCheckDI(MapUpdater map) {
        super(map);
        this.cycle.add(new Radar(map, Heading.EAST)); //1
        this.cycle.add(new Radar(map, Heading.WEST)); //2
        this.cycle.add(new Flyer(map));
    }

    @Override
    public State getNext() {
        return next;
    }

    @Override
    public void update(JSONObject response) {
        // Check if we found ground from Radar
        if (parser.echoGround(response).equals("GROUND") && step_count % 3 == 1) {
            map.updateScanHeading(Heading.EAST);
            next = new TurnAfterNorthSouthCheckDI(map);
            go_next= true;
        } else if (parser.echoGround(response).equals("GROUND") && step_count % 3 == 2) {
            map.updateScanHeading(Heading.WEST);
            next = new TurnAfterNorthSouthCheckDI(map);
            go_next= true;
        }
    }
}