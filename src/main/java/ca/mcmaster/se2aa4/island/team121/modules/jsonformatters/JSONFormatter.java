package ca.mcmaster.se2aa4.island.team121.modules.jsonformatters;

import ca.mcmaster.se2aa4.island.team121.businessdrivenobjects.Action;
import org.json.JSONObject;

public interface JSONFormatter {
    public JSONObject format(Action action);
}
