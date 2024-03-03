package ca.mcmaster.se2aa4.island.team121.Modules;

import ca.mcmaster.se2aa4.island.team121.Action;
import org.json.JSONObject;

public abstract class Module {

    protected JSONHandler jsoner;
    protected Action action;

    public JSONObject getJSON() {
        return this.jsoner.format(action);
    }
}
