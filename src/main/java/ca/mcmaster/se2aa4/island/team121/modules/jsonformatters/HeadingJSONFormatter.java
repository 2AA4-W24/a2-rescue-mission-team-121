package ca.mcmaster.se2aa4.island.team121.modules.jsonformatters;

import ca.mcmaster.se2aa4.island.team121.businessdrivenobjects.Heading;
import org.json.JSONObject;

public interface HeadingJSONFormatter {
    JSONObject addHeading(JSONObject curr_json, Heading heading);
}
