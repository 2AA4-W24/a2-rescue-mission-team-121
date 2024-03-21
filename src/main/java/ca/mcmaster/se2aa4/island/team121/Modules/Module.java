package ca.mcmaster.se2aa4.island.team121.Modules;

import ca.mcmaster.se2aa4.island.team121.BusinessDrivenObjects.Action;
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

    public void updateMap() {} // Most Modules do not do anything with the map
}
