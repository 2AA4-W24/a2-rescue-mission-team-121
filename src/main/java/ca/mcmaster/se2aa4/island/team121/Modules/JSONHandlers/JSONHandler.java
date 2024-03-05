package ca.mcmaster.se2aa4.island.team121.Modules.JSONHandlers;

import ca.mcmaster.se2aa4.island.team121.Action;
import org.json.JSONObject;

public interface JSONHandler {
    public JSONObject format(Action action);
}
