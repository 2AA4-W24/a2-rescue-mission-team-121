package ca.mcmaster.se2aa4.island.team121.Modules;

import ca.mcmaster.se2aa4.island.team121.Decision;
import org.json.JSONObject;

public class Radar implements Module {

    private final Decision op = Decision.ECHO;
    @Override
    public JSONObject getJSON() {
        return new JSONObject().put("action", op.getName());
    }

    @Override
    public Decision getDecision() {
        return op;
    }
}
