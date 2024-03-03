package ca.mcmaster.se2aa4.island.team121.Modules.JSONHandlers;

import ca.mcmaster.se2aa4.island.team121.Action;
import ca.mcmaster.se2aa4.island.team121.Heading;
import org.json.JSONObject;

public interface HeadingJSONHandler {
    public JSONObject addHeading(JSONObject curr_json, Heading heading);
}
