package ca.mcmaster.se2aa4.island.team121.Modules;

import ca.mcmaster.se2aa4.island.team121.Decision;
import org.json.JSONObject;

public class Turner implements Module {

    private final Decision op = Decision.TURN;
    @Override
    public JSONObject getJSON() {
        return new JSONObject().put("action", op.toString());
    }

    @Override
    public Decision getDecision() {
        return op;
    }
}
