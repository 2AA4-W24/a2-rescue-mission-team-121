package ca.mcmaster.se2aa4.island.team121.DroneState.JSONParser;

import ca.mcmaster.se2aa4.island.team121.TileType;
import org.json.JSONObject;

public interface JSONParser {
    TileType getScan(JSONObject response);
    boolean echoGround(JSONObject response);
    int echoDistance(JSONObject response);

    int getCost(JSONObject response);


}
