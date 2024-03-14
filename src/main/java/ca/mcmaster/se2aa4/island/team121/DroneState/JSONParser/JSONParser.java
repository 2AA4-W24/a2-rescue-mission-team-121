package ca.mcmaster.se2aa4.island.team121.DroneState.JSONParser;

import ca.mcmaster.se2aa4.island.team121.TileType;
import org.json.JSONObject;

import java.util.ArrayList;

public interface JSONParser {
    TileType getScan(JSONObject response);
    String echoGround(JSONObject response);
    int echoDistance(JSONObject response);

    int getCost(JSONObject response);

    ArrayList<String> getId(JSONObject response);
}
