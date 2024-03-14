package ca.mcmaster.se2aa4.island.team121.Modules.JSONFormatters;

import ca.mcmaster.se2aa4.island.team121.Action;
import org.json.JSONObject;

public interface JSONFormatter {
    public JSONObject format(Action action);
}
