package ca.mcmaster.se2aa4.island.team121.Modules;

import ca.mcmaster.se2aa4.island.team121.Decision;
import ca.mcmaster.se2aa4.island.team121.Heading;

import org.json.JSONObject;

public class Radar implements ModuleHeading {

    private final Decision op = Decision.ECHO;

    @Override
    public JSONObject getJSON(Heading heading) {
        return new JSONObject().put("action", op.getName());
    }

}
