package ca.mcmaster.se2aa4.island.team121.Modules;

import ca.mcmaster.se2aa4.island.team121.Action;
import ca.mcmaster.se2aa4.island.team121.Modules.JSONFormatters.JSONFormatter;
import ca.mcmaster.se2aa4.island.team121.Records.MapUpdater;
import org.json.JSONObject;

public abstract class Module {

    protected JSONFormatter jsoner;
    protected Action action;
    protected MapUpdater map;

    public Module(MapUpdater map) {
        this.map = map;
    }

    public JSONObject getJSON() {
        return this.jsoner.format(action);
    }

    public abstract void updateMap();
}
