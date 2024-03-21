package ca.mcmaster.se2aa4.island.team121.DroneState.JSONParser;

import ca.mcmaster.se2aa4.island.team121.TileType;
import org.json.JSONObject;
import java.util.ArrayList;
import org.json.JSONArray;

public class DefaultJSONParser implements JSONParser{
    private final String extrasStr = "extras";
    private final String creeksStr = "creeks";
    private final String sitesStr = "sites";

    @Override
    public TileType getScan(JSONObject response) {
         if(response.has(extrasStr)){
                JSONObject extras = response.getJSONObject(extrasStr);
                if(extras.has(creeksStr)){
                    JSONArray creeks = extras.getJSONArray(creeksStr);
                    if(!creeks.isEmpty()){
                        return TileType.CREEK;
                    }
                }
            }
         if (response.has(extrasStr)){
             JSONObject extras = response.getJSONObject(extrasStr);
             if (extras.has(sitesStr)){
                if (!extras.getJSONArray(sitesStr).isEmpty()){
                    return TileType.SITE;
                }
             }
         }

        return TileType.UNKNOWN;
    }
    @Override
    public String echoGround(JSONObject response) {
        String found = "NO_SCAN";
        if (response.has(extrasStr)) {
            JSONObject extras = response.getJSONObject(extrasStr);
            if (extras.has("found")) {
                found = extras.getString("found");
            }
        }
        return found;
    }

    @Override
    public int echoDistance(JSONObject response) {
        if(response.has(extrasStr)){
            JSONObject extras = response.getJSONObject(extrasStr);
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
        ArrayList<String> Ids = new ArrayList<>();
        if (response.has(extrasStr)) {
            JSONObject extras = response.getJSONObject(extrasStr);
            if(extras.has(creeksStr)){
                JSONArray creeks = extras.getJSONArray(creeksStr);
                if (!creeks.isEmpty()){
                    for (int i = 0; i < creeks.length(); i++){
                        Ids.add(creeks.getString(i));
                    }
                }
            }
            if(extras.has(sitesStr)){
                JSONArray sites = extras.getJSONArray(sitesStr);
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
