package ca.mcmaster.se2aa4.island.team121.modules.jsonformatters;

import ca.mcmaster.se2aa4.island.team121.Action;
import org.json.JSONObject;

public class DefaultJSONFormatter implements JSONFormatter {
    @Override
    public JSONObject format(Action action) {
        return new JSONObject().put("action", action.getName());
    }
}
