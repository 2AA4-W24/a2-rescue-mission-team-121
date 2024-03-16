package ca.mcmaster.se2aa4.island.team121.DroneState.JSONParser;

import ca.mcmaster.se2aa4.island.team121.TileType;
import org.apache.bcel.generic.NEW;
import org.json.JSONObject;
import java.util.ArrayList;
import org.json.JSONArray;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class DefaultJSONParser implements JSONParser{
    private static final Logger logger = LogManager.getLogger(DefaultJSONParser.class);
    @Override
    public TileType getScan(JSONObject response) {
         if(response.has("extras")){
                JSONObject extras = response.getJSONObject("extras");
                if(extras.has("creeks")){
                    JSONArray creeks = extras.getJSONArray("creeks");
                    if(!creeks.isEmpty()){
                        logger.info("Creek found");
                        return TileType.CREEK;
                    }
                }
            }
         if (response.has("extras")){
             JSONObject extras = response.getJSONObject("extras");
             if (extras.has("sites")){
                if (extras.getJSONArray("sites").length() > 0){
                    return TileType.SITE;
                }
             }
         }

        return TileType.UNKNOWN;
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

    @Override
    public ArrayList<String> getId(JSONObject response) {
        ArrayList<String> Ids = new ArrayList<String>();
        if (response.has("extras")) {
            JSONObject extras = response.getJSONObject("extras");
            if(extras.has("creeks")){
                JSONArray creeks = extras.getJSONArray("creeks");
                if (!creeks.isEmpty()){
                    for (int i = 0; i < creeks.length(); i++){
                        Ids.add(creeks.getString(i));
                    }
                }
            }
            if(extras.has("sites")){
                JSONArray sites = extras.getJSONArray("sites");
                if (!sites.isEmpty()){
                    for (int i = 0; i < sites.length(); i++){
                        Ids.add(sites.getString(i));
                    }
                }
            }
        }
        return Ids;
    }


}
