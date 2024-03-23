package ca.mcmaster.se2aa4.island.team121;

import ca.mcmaster.se2aa4.island.team121.modules.Stopper;
import ca.mcmaster.se2aa4.island.team121.records.AttributeRecord;
import ca.mcmaster.se2aa4.island.team121.records.RelativeMap;
import ca.mcmaster.se2aa4.island.team121.dronestate.State;
import ca.mcmaster.se2aa4.island.team121.dronestate.doubleinterlaced.GridSearchStartDI;
import ca.mcmaster.se2aa4.island.team121.dronestate.doubleinterlaced.NorthSouthCheckDI;
import eu.ace_design.island.bot.IExplorerRaid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unused")
public class Explorer implements IExplorerRaid {

    private final Logger logger = LogManager.getLogger();
    private final AttributeRecord drone_attributes = new AttributeRecord();
    private RelativeMap map;
    private State curr_state;



    @Override
    public void initialize(String s) {
        Heading start_heading;
        logger.info("** Initializing the Exploration Command Center");
        JSONObject info = new JSONObject(new JSONTokener(new StringReader(s)));
        logger.info("** Initialization info:\n {}", info.toString(2));
        String direction = info.getString("heading");
        Integer batteryLevel = info.getInt("budget");
        logger.info("The drone is facing {}", direction);
        logger.info("Battery level is {}", batteryLevel);

        // initialize records with info
        drone_attributes.updateAttributes(batteryLevel, -1, -1);
        map = new RelativeMap(Heading.headingOf(direction));
        map.updateScanHeading(Heading.headingOf(direction));
        start_heading = map.getScanHeading();
        if (start_heading == Heading.EAST || start_heading == Heading.WEST) {
            curr_state = new GridSearchStartDI(map);
        }
        else {
            curr_state = new NorthSouthCheckDI(map);
        }

    }

    @Override
    public String takeDecision() {
        JSONObject decision;
        if (drone_attributes.getBattery() < 100) {
            decision = new Stopper(map).getJSON();
        } else {
            curr_state = curr_state.isGoNext() ? curr_state.getNext() : curr_state;
            decision = curr_state.execute();
        }
        return decision.toString();
    }

    @Override
    public void acknowledgeResults(String s) {
        JSONObject response = new JSONObject(new JSONTokener(new StringReader(s)));

        String status = response.getString("status");
        JSONObject extraInfo = response.getJSONObject("extras");

        // update the battery level
        drone_attributes.updateAttributes(drone_attributes.getBattery() - response.getInt("cost"), -1, -1);
        curr_state.update(response);
    }

    @Override
    public String deliverFinalReport() {
        map.displayMap();

        Map<TileRecord, Double> creek_distances = map.getCreekSiteDistances();
        List<Double> distances_list = new ArrayList<>(creek_distances.values());
        Collections.sort(distances_list);
        for (Map.Entry<TileRecord, Double> entry : creek_distances.entrySet()) {
            logger.info("Creek: {} Distance: {}", entry.getKey().id().get(0), entry.getValue());
        }

        if (!creek_distances.isEmpty()) {
            Double closest_distance = distances_list.get(0);
            for (Map.Entry<TileRecord, Double> entry : creek_distances.entrySet()) {
                if (entry.getValue().equals(closest_distance)) {
                    TileRecord closest_creek = entry.getKey();
                    logger.info("Closest Creek: {}", closest_creek.id().get(0));
                    return closest_creek.id().get(0);
                }
            }
        }
        return "no creek found";
    }
}
