package ca.mcmaster.se2aa4.island.team121.Modules.JSONFormatters;

import ca.mcmaster.se2aa4.island.team121.Heading;
import org.json.JSONObject;

public interface HeadingJSONFormatter {
    public JSONObject addHeading(JSONObject curr_json, Heading heading);
}
