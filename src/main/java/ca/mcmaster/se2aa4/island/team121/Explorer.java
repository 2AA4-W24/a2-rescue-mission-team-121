package ca.mcmaster.se2aa4.island.team121;

import java.io.StringReader;
import ca.mcmaster.se2aa4.island.team121.Records.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import eu.ace_design.island.bot.IExplorerRaid;
import org.json.JSONObject;
import org.json.JSONTokener;

public class Explorer implements IExplorerRaid {

    private final Logger logger = LogManager.getLogger();

    private Decision last_action;
    private Decision next_action = Decision.STOP;
    private int distG;
    private MovesRecord moves = new MovesRecord();
    private AttributeRecord drone_attributes = new AttributeRecord();
    private MapUpdater map;

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
        JSONObject decision = new JSONObject();

        // If the moves record is empty, start with an echo
        if (moves.movesIsEmpty()) {
            last_action = Decision.ECHO;
            moves.add(last_action);
        }
        else
        {
            last_action = moves.getLastMove(); // returns the last Decision object in movesrecord.
        }



        // Needs to be fixed: the numbers that echo returns as a response must be used
        // to further determine the next action.
        // Turn needs to be implemented based on which direction the echo is successful
        if (last_action.equals(Decision.ECHO)) {
            distG = drone_attributes.getDistG();
            next_action = Decision.FLY;
        }

        // If the last action was fly, continue to the edge of the island, until ground
        // is hit, when ground is hit, scan
        if (last_action.equals(Decision.FLY)) {
            if (distG > 0) {
                next_action = Decision.FLY;
                distG--;
            } else {
                next_action = Decision.SCAN;
            }
            map.updateFly();
        }

        // If scan is ground, means edge of island was found, go back to base, if not,
        // keep flying
        if (last_action.equals(Decision.SCAN)) {
            if (map.isOverGound()) {
                map.updateScan(TileType.GROUND);
                next_action = Decision.STOP;
            } else {
                next_action = Decision.FLY;
            }
        }

        else {
            next_action = Decision.STOP;
        }
        if (last_action.equals(Decision.SCAN)) {
            last_action = Decision.STOP;

        } else {
            last_action = Decision.FLY;
            last_action = Decision.SCAN;
        }
        decision.put("action", next_action.getName());
        logger.info("** Decision: {}", decision.toString());

        return decision.toString();

    }

    @Override
    public void acknowledgeResults(String s) {
        JSONObject response = new JSONObject(new JSONTokener(new StringReader(s)));
        logger.info("** Response received:\n" + response.toString(2));
        Integer cost = response.getInt("cost");
        logger.info("The cost of the action was {}", cost);
        String status = response.getString("status");
        logger.info("The status of the drone is {}", status);
        JSONObject extraInfo = response.getJSONObject("extras");
        logger.info("Additional information received: {}", extraInfo);

        // update the battery level
        drone_attributes.updateAttributes(drone_attributes.getBattery() - response.getInt("cost"), -1, -1);
        // update the map with the new tile type if we scanned
        if (response.has("biomes")) {
            map.updateScan(TileType.TileTypeOf(response.getString("biomes")));
        }
    }

    @Override
    public String deliverFinalReport() {
        return "no creek found";
    }

}
