package ca.mcmaster.se2aa4.island.team121.Modules.JSONFormatters;

import ca.mcmaster.se2aa4.island.team121.BusinessDrivenObjects.Action;
import org.json.JSONObject;

public class DefaultJSONFormatter implements JSONFormatter {
    @Override
    public JSONObject format(Action action) {
        return new JSONObject().put("action", action.getName());
    }
}
