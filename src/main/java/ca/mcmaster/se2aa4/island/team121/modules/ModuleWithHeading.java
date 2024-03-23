package ca.mcmaster.se2aa4.island.team121.modules;

import ca.mcmaster.se2aa4.island.team121.Heading;
import ca.mcmaster.se2aa4.island.team121.modules.jsonformatters.HeadingJSONFormatter;
import ca.mcmaster.se2aa4.island.team121.records.MapUpdater;
import org.json.JSONObject;

public abstract class ModuleWithHeading extends Module {

    protected HeadingJSONFormatter heading_jsoner;
    protected final Heading heading;

    public ModuleWithHeading(MapUpdater map, Heading heading) {
        super(map);
        this.heading = heading;
    }

    @Override
    public JSONObject getJSON() {
        JSONObject json = this.jsoner.format(action);
        json = this.heading_jsoner.addHeading(json, this.heading);
        return json;
    }
}
