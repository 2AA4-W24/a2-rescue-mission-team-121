package ca.mcmaster.se2aa4.island.team121.modules.jsonformatters;

import ca.mcmaster.se2aa4.island.team121.Action;
import org.json.JSONObject;

public interface JSONFormatter {
    JSONObject format(Action action);
}
