package ca.mcmaster.se2aa4.island.team121.Modules.JSONHandlers;

import ca.mcmaster.se2aa4.island.team121.Heading;
import org.json.JSONObject;

public class DefaultHeadingJSONHandler implements HeadingJSONHandler {
    @Override
    public JSONObject addHeading(JSONObject curr_json, Heading heading) {
        return curr_json.put("parameters", new JSONObject().put("direction", heading.getVector()));
    }
}
