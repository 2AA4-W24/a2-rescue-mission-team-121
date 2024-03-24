package ca.mcmaster.se2aa4.island.team121.modules;

import ca.mcmaster.se2aa4.island.team121.businessdrivenobjects.Action;
import ca.mcmaster.se2aa4.island.team121.modules.jsonformatters.JSONFormatter;
import ca.mcmaster.se2aa4.island.team121.records.MapUpdater;
import org.json.JSONObject;

public abstract class Module {

    protected JSONFormatter jsoner;
    protected Action action;
    protected final MapUpdater map;

    public Module(MapUpdater map) {
        this.map = map;
    }

    public JSONObject getJSON() {
        return this.jsoner.format(action);
    }

    public void updateMap() {} // Most Modules do not do anything with the map
}
