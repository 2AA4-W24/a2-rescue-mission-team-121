package ca.mcmaster.se2aa4.island.team121.jsonparser;

import ca.mcmaster.se2aa4.island.team121.businessdrivenobjects.TileType;
import org.json.JSONObject;

import java.util.List;

public interface JSONParser {
    TileType getScan(JSONObject response);
    String echoGround(JSONObject response);
    int echoDistance(JSONObject response);

    int getCost(JSONObject response);

    List<String> getId(JSONObject response);
}
