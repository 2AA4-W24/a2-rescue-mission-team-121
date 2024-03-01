package ca.mcmaster.se2aa4.island.team121;

import java.io.StringReader;

import ca.mcmaster.se2aa4.island.team121.DroneState.State;
import ca.mcmaster.se2aa4.island.team121.Modules.*;
import ca.mcmaster.se2aa4.island.team121.Modules.Module;
import ca.mcmaster.se2aa4.island.team121.Records.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import eu.ace_design.island.bot.IExplorerRaid;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import javax.xml.stream.events.StartElement;

public class Explorer implements IExplorerRaid {

    private final Logger logger = LogManager.getLogger();
    boolean found_ground = false;
    private Decision next_action = Decision.STOP;
    private MovesRecord moves = new MovesRecord();
    private AttributeRecord drone_attributes = new AttributeRecord();
    private RelativeMap map = new RelativeMap(Heading.EAST);
    private State curr_state = State.Start;

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
        if (map.isOverGound()) {
            next_action = Decision.STOP;
            decision.put("action", next_action.getName());
            return decision.toString();
        }
        if (!found_ground) {
            if (moves.movesIsEmpty()) {
                next_action = Decision.ECHO;
                moves.add(next_action);
                curr_state = State.look4Ground;
                ModuleHeading echo = new Radar();
                decision = echo.getJSON(Heading.SOUTH);
            } else if (moves.getLastMove() == Decision.FLY) {
                next_action = Decision.SCAN;
                moves.add(next_action);
                curr_state = State.look4Ground;
                Module scan = new Scanner();
                decision = scan.getJSON();
            } else if (moves.getLastMove() == Decision.SCAN) {
                next_action = Decision.ECHO;
                moves.add(next_action);
                curr_state = State.look4Ground;
                ModuleHeading echo = new Radar();
                decision = echo.getJSON(Heading.SOUTH);
            } else if (moves.getLastMove() == Decision.ECHO) {
                next_action = Decision.FLY;
                moves.add(next_action);
                curr_state = State.look4Ground;
                Module fly = new Flyer();
                map.updateFly();
                decision = fly.getJSON();
            }
        }
        else {
            if (map.getCurrentHeading() != Heading.SOUTH){
                next_action = Decision.HEADING;
                moves.add(next_action);
                curr_state = State.flyToBeach;
                ModuleHeading heading = new Turner();
                decision = heading.getJSON(Heading.SOUTH);
                map.updateTurn(Heading.SOUTH);
            }
            else {
                if(moves.getLastMove() == Decision.HEADING || moves.getLastMove()==Decision.SCAN){
                    next_action = Decision.FLY;
                    moves.add(next_action);
                    curr_state = State.flyToBeach;
                    Module fly = new Flyer();
                    decision = fly.getJSON();
                    map.updateFly();
                }
                else if (moves.getLastMove() == Decision.FLY){
                    next_action = Decision.SCAN;
                    moves.add(next_action);
                    curr_state = State.flyToBeach;
                    Module scan = new Scanner();
                    decision = scan.getJSON();
                }
            }
        }
        logger.info(curr_state.getName());
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
        if (response.has("extras")) {
            JSONObject extras = response.getJSONObject("extras");
            if(extras.has("biomes")){
                JSONArray biomes = extras.getJSONArray("biomes");
                map.updateScan(TileType.TileTypeOf(biomes.getString(0)));

            }
        }

        if (response.has("extras")) {
            JSONObject extras = response.getJSONObject("extras");
            if (extras.has("found")) {
                String found = extras.getString("found");
                if ("GROUND".equals(found)) {
                    // Do something when found is GROUND
                     found_ground = true;
                }
            }
        }
    }

    @Override
    public String deliverFinalReport() {
        return "no creek found";
    }

}
