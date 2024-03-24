package ca.mcmaster.se2aa4.island.team121.jsonparser;

import ca.mcmaster.se2aa4.island.team121.businessdrivenobjects.TileType;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
public class DefaultJSONParser implements JSONParser{
    private final String extrasStr="extras";
    private final String creeksStr="creeks";
    private final String sitesStr="sites";
    private final String foundStr="found";
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
    //FIXME: Need to modify logic to handle null when echo is not used
    @Override
    public String echoGround(JSONObject response) {
        String found = "NO_SCAN";
        if (response.has(extrasStr)) {
            JSONObject extras = response.getJSONObject(extrasStr);
            if (extras.has(foundStr)) {
                found = extras.getString(foundStr);
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
        ArrayList<String> ids = new ArrayList<>();
        if (response.has(extrasStr)) {
            JSONObject extras = response.getJSONObject(extrasStr);
            if(extras.has(creeksStr)){
                JSONArray creeks = extras.getJSONArray(creeksStr);
                if (!creeks.isEmpty()){
                    for (int i = 0; i < creeks.length(); i++){
                        ids.add(creeks.getString(i));
                    }
                }
            }
            if(extras.has(sitesStr)){
                JSONArray sites = extras.getJSONArray(sitesStr);
                if (!sites.isEmpty()){
                    for (int i = 0; i < sites.length(); i++){
                        ids.add(sites.getString(i));
                    }
                }
            }
        }
        return ids;
    }
}
