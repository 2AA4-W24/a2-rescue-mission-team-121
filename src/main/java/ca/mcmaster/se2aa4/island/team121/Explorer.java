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
    private RelativeMap map = new RelativeMap(Heading.EAST);

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
        if (next_action == Decision.STOP) {
            decision.put("action", "stop");
            return decision.toString();
        }
        // If the moves record is empty, start with an echo
        if((next_action == Decision.HEADING) && ( Heading.SOUTH == map.getCurrentHeading()))
        {
            map.updateTurn(Heading.headingOf("S"));
            decision.put("action", next_action.getName());
            decision.put("parameters", new JSONObject().put("direction", "S"));
            moves.add(next_action);
            last_action=Decision.ECHO;
            return decision.toString();
        }

        if (moves.movesIsEmpty()) {
            last_action = Decision.ECHO;
            moves.add(last_action);
        }
        else
        {
            last_action = moves.getLastMove(); // returns the last Decision object in moves record.
        }
        if (last_action == Decision.ECHO) {
            next_action = Decision.SCAN;
            decision.put("action", "scan");
            moves.add(next_action);
            return decision.toString();

        }
        else if (last_action == Decision.SCAN) {
            next_action = Decision.FLY;
            decision.put("action", next_action.getName());
            moves.add(next_action);
            return decision.toString();

        }
        else if (last_action == Decision.FLY) {
            next_action = Decision.ECHO;

            decision.put("action", next_action.getName());
            decision.put("parameters", new JSONObject().put("direction", "S"));

            moves.add(next_action);
            return decision.toString();

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
        if (response.has("extras")) {
            JSONObject extras = response.getJSONObject("extras");
            if (extras.has("found")) {
                String found = extras.getString("found");
                if ("GROUND".equals(found)) {
                    // Do something when found is GROUND
                    next_action = Decision.HEADING;
                }
            }
        }


    }

    @Override
    public String deliverFinalReport() {
        return "no creek found";
    }

}
