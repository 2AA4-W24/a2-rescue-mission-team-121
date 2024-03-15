package ca.mcmaster.se2aa4.island.team121;

import java.io.StringReader;

import ca.mcmaster.se2aa4.island.team121.DroneState.DoubleInterlaced.GridSearchStartDI;
import ca.mcmaster.se2aa4.island.team121.DroneState.GridSearch.GridSearchStart;
import ca.mcmaster.se2aa4.island.team121.DroneState.State;
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
    private State curr_state = new GridSearchStartDI(map, drone_attributes);

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
        map = new RelativeMap(Heading.headingOf(direction));
    }

    @Override
    public String takeDecision() {
        JSONObject decision;

        curr_state = (curr_state.isGoNext()) ? curr_state.getNext() : curr_state;
        decision = curr_state.execute();

        logger.info("Decision: {}", decision.toString(2));
        return decision.toString();
    }

    @Override
    public void acknowledgeResults(String s) {
        JSONObject response = new JSONObject(new JSONTokener(new StringReader(s)));
      
        Integer cost = response.getInt("cost");
        String status = response.getString("status");
        JSONObject extraInfo = response.getJSONObject("extras");
        logger.info("\n");

        // update the battery level
        drone_attributes.updateAttributes(drone_attributes.getBattery() - response.getInt("cost"), -1, -1);
        logger.info("Battery Used:"+ (70000-drone_attributes.getBattery()));
        curr_state.update(response);
    }

    @Override
    public String deliverFinalReport() {
        return "no creek found";
    }
}
