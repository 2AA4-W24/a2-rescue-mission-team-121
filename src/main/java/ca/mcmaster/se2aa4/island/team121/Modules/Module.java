package ca.mcmaster.se2aa4.island.team121.Modules;

import ca.mcmaster.se2aa4.island.team121.Decision;
import org.json.JSONObject;

public interface Module {
    JSONObject getJSON();
    Decision getDecision();
}
