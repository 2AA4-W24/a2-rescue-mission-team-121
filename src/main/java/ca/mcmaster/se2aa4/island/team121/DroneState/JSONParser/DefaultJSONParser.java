package ca.mcmaster.se2aa4.island.team121.DroneState.JSONParser;

import ca.mcmaster.se2aa4.island.team121.TileType;
import org.json.JSONObject;

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

    @Override
    public boolean echoGround(JSONObject response) {
       if(response.has("extras")){
           JSONObject extras = response.getJSONObject("extras");
           if(extras.has("found")){
                String found = extras.getString("found");
                if("OUT_OF_RANGE".equals(found)){
                     return false;
                }
                else {
                    return true;
                }
           }
       }
        return false;
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
