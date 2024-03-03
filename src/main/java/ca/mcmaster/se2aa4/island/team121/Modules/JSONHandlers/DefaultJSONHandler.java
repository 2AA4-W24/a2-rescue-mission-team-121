package ca.mcmaster.se2aa4.island.team121.Modules.JSONHandlers;

import ca.mcmaster.se2aa4.island.team121.Action;
import org.json.JSONObject;

public class DefaultJSONHandler implements JSONHandler {
    @Override
    public JSONObject format(Action action) {
        return new JSONObject().put("action", action.getName());
    }
}
