package ca.mcmaster.se2aa4.island.team121.Modules.JSONFormatters;

import ca.mcmaster.se2aa4.island.team121.Heading;
import org.json.JSONObject;

public class DefaultHeadingJSONFormatter implements HeadingJSONFormatter {
    @Override
    public JSONObject addHeading(JSONObject curr_json, Heading heading) {
        return curr_json.put("parameters", new JSONObject().put("direction", heading.getVector()));
    }
}
