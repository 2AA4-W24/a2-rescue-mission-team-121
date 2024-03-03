package ca.mcmaster.se2aa4.island.team121.Modules;

import ca.mcmaster.se2aa4.island.team121.Heading;
import ca.mcmaster.se2aa4.island.team121.Modules.JSONHandlers.HeadingJSONHandler;
import org.json.JSONObject;

public abstract class ModuleWithHeading extends Module {

    protected HeadingJSONHandler heading_jsoner;
    protected Heading heading;

    public ModuleWithHeading(Heading heading) {
        this.heading = heading;
    }

    @Override
    public JSONObject getJSON() {
        JSONObject json = this.jsoner.format(action);
        json = this.heading_jsoner.addHeading(json, this.heading);
        return json;
    }
}
