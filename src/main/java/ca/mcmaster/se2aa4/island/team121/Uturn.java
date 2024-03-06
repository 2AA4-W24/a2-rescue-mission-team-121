package ca.mcmaster.se2aa4.island.team121;

import ca.mcmaster.se2aa4.island.team121.Modules.*;
import ca.mcmaster.se2aa4.island.team121.Modules.Module;
import ca.mcmaster.se2aa4.island.team121.Records.MapUpdater;
import ca.mcmaster.se2aa4.island.team121.Records.RelativeMap;
import eu.ace_design.island.game.Engine;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;


public class Uturn {
    Module fly = new Flyer();
    Module scan = new Scanner();
    Heading dir;
    ModuleWithHeading turn = new Turner(dir);
    RelativeMap map;


    private final Logger logger = LogManager.getLogger();


    JSONObject json;

    public Uturn(RelativeMap map)
    {
        this.map = map;
    }



    public JSONObject North2SouthEast(int curr_step) {
        switch (curr_step) {
            case 0 -> {
                dir = Heading.WEST;
                map.updateTurn(dir);
                json = turn.getJSON();
            }

            case 2 -> {
                dir = Heading.NORTH;
                map.updateTurn(dir);
                json= turn.getJSON();
            }

            case 4 -> {
                dir = Heading.EAST;
                map.updateTurn(dir);
                json= turn.getJSON();
            }

            case 6, 10, 12 -> {
                map.updateFly();
                json= fly.getJSON();
            }

            case 8 -> {
                dir = Heading.SOUTH;
                map.updateTurn(dir);
                json= turn.getJSON();
            }

            default -> {
                json= scan.getJSON();
            }

        }
        logger.info(map.getCurrentHeading().toString());
        return json;
    }


    public JSONObject South2NorthEast(int curr_step) {
        switch (curr_step) {
            case 0 -> {
                dir = Heading.WEST;
                map.updateTurn(dir);
                json = turn.getJSON();
            }
            case 2 -> {
                dir = Heading.SOUTH;
                map.updateTurn(dir);
                json = turn.getJSON();
            }
            case 4 -> {
                dir = Heading.EAST;
                map.updateTurn(dir);
                json = turn.getJSON();
            }
            case 6, 10, 12 -> {
                map.updateFly();
                json = fly.getJSON();
            }
            case 8 -> {
                dir = Heading.NORTH;
                map.updateTurn(dir);
                json = turn.getJSON();
            }
            default -> {
                json = scan.getJSON();
            }
        }
        logger.info(map.getCurrentHeading().toString());
        return json;
    }

}
