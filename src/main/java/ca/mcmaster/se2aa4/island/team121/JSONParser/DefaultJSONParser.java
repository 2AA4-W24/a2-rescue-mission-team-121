package ca.mcmaster.se2aa4.island.team121.JSONParser;

import ca.mcmaster.se2aa4.island.team121.BusinessDrivenObjects.TileType;
import org.json.JSONObject;
import java.util.ArrayList;
import org.json.JSONArray;
public class DefaultJSONParser implements JSONParser{
    @Override
    public TileType getScan(JSONObject response) {
         if(response.has("extras")){
                JSONObject extras = response.getJSONObject("extras");
                if(extras.has("creeks")){
                    JSONArray creeks = extras.getJSONArray("creeks");
                    if(!creeks.isEmpty()){
//                        logger.info("Creek found");
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
        if(response.has("cost")){
            return response.getInt("cost");
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