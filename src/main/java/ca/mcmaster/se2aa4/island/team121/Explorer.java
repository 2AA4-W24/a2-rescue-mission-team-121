package ca.mcmaster.se2aa4.island.team121;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import ca.mcmaster.se2aa4.island.team121.DroneState.ProgressiveScan.*;
import ca.mcmaster.se2aa4.island.team121.DroneState.InterlacedScan.*;
import ca.mcmaster.se2aa4.island.team121.DroneState.*;
import ca.mcmaster.se2aa4.island.team121.Modules.*;
import ca.mcmaster.se2aa4.island.team121.Records.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import eu.ace_design.island.bot.IExplorerRaid;
import org.json.JSONObject;
import org.json.JSONTokener;

public class Explorer implements IExplorerRaid {

    private final Logger logger = LogManager.getLogger();
    private AttributeRecord drone_attributes = new AttributeRecord();
    private RelativeMap map = new RelativeMap(Heading.EAST);
    private State curr_state = new InterlacedStart(map, drone_attributes);

    @Override
    public void initialize(String s) {
        logger.info("** Initializing the Exploration Command Center");
        JSONObject info = new JSONObject(new JSONTokener(new StringReader(s)));
        logger.info("** Initialization info:\n {}", info.toString(2));
        String direction = info.getString("heading");
        Integer batteryLevel = info.getInt("budget");
        logger.info("The drone is facing {}", direction);
        logger.info("Battery level is {}", batteryLevel);

        // initialize records with info
        drone_attributes.updateAttributes(batteryLevel, -1, -1);
    }

    @Override
    public String takeDecision() {
        JSONObject decision;
        if (drone_attributes.getBattery() < 100) {
            decision = new Stopper(map).getJSON();
        } else {
            curr_state = (curr_state.isGoNext()) ? curr_state.getNext() : curr_state;
            decision = curr_state.execute();
        }
        return decision.toString();
    }

    @Override
    public void acknowledgeResults(String s) {
        JSONObject response = new JSONObject(new JSONTokener(new StringReader(s)));
      
        Integer cost = response.getInt("cost");
        String status = response.getString("status");
        JSONObject extraInfo = response.getJSONObject("extras");

        // update the battery level
        drone_attributes.updateAttributes(drone_attributes.getBattery() - response.getInt("cost"), -1, -1);
        curr_state.update(response);
    }

    @Override
    public String deliverFinalReport() {
        Map<TileRecord, Double> creek_distances = map.getCreekSiteDistances();
        List<Double> creek_distances_list = new ArrayList<>(creek_distances.values());
        Collections.sort(creek_distances_list);

        if (!creek_distances.isEmpty()) {
            Double closest_distance = creek_distances_list.get(0);
            for (Map.Entry<TileRecord, Double> entry : creek_distances.entrySet()) {
                if (entry.getValue().equals(closest_distance)) {
                    TileRecord creek = entry.getKey();
                    return creek.id().get(0);
                }
            }
        }
        return "no creek found";
    }
}
