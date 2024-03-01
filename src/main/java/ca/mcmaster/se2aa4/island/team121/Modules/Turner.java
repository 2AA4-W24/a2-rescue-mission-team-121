package ca.mcmaster.se2aa4.island.team121.Modules;

import ca.mcmaster.se2aa4.island.team121.Decision;
import ca.mcmaster.se2aa4.island.team121.Heading;

import org.json.JSONObject;

public class Turner implements ModuleHeading {

    private final Decision op = Decision.HEADING;

    @Override
    public JSONObject getJSON(Heading heading) {
        JSONObject json = new JSONObject();
        json.put("action", op.getName());
        json.put("parameters", new JSONObject().put("direction", heading.getVector()));

        return json;
    }
}
