package ca.mcmaster.se2aa4.island.team121.Modules;

import ca.mcmaster.se2aa4.island.team121.BusinessDrivenObjects.Heading;
import ca.mcmaster.se2aa4.island.team121.Modules.JSONFormatters.HeadingJSONFormatter;
import ca.mcmaster.se2aa4.island.team121.Records.MapUpdater;
import org.json.JSONObject;

public abstract class ModuleWithHeading extends Module {

    protected HeadingJSONFormatter heading_jsoner;
    protected Heading heading;

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
