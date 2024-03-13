package ca.mcmaster.se2aa4.island.team121.DroneState.JSONParser;

import ca.mcmaster.se2aa4.island.team121.TileType;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;

import java.util.logging.LogManager;

public class DefaultJSONParser implements JSONParser{

    @Override
    public TileType getScan(JSONObject response) {
        if (response.has("extras")) {
            JSONObject extras = response.getJSONObject("extras");
            if(extras.has("biomes")){
                return TileType.TileTypeOf(extras.getJSONArray("biomes").getString(0));
            }
        }
        return null;

    }


    //FIXME: Need to modify logic to handle null when echo is not used
    @Override
    public String echoGround(JSONObject response) {
        String found = "NO_SCAN";
        if (response.has("extras")) {
            JSONObject extras = response.getJSONObject("extras");
            if (extras.has("found")) {
                found = extras.getString("found");

            }
        }
        return found;
    }

    @Override
    public int echoDistance(JSONObject response) {
        if(response.has("extras")){
            JSONObject extras = response.getJSONObject("extras");
            if(extras.has("range")){
                return extras.getInt("range");
            }
        }
        return -1;
    }

    @Override
    public int getCost(JSONObject response) {
        if (response.has("data")) {
            JSONObject data = response.getJSONObject("data");
            if(data.has("cost")){
                return data.getInt("cost");
            }
        }
        return -1;
    }

}
