package ca.mcmaster.se2aa4.island.team121.modules;


import ca.mcmaster.se2aa4.island.team121.Action;
import ca.mcmaster.se2aa4.island.team121.Heading;
import ca.mcmaster.se2aa4.island.team121.modules.jsonformatters.DefaultHeadingJSONFormatter;
import ca.mcmaster.se2aa4.island.team121.modules.jsonformatters.DefaultJSONFormatter;
import ca.mcmaster.se2aa4.island.team121.records.MapUpdater;

public class Radar extends ModuleWithHeading {
    public Radar(MapUpdater map, Heading heading) {
        super(map, heading);
        this.action = Action.ECHO;
        this.jsoner = new DefaultJSONFormatter();
        this.heading_jsoner = new DefaultHeadingJSONFormatter();
    }
}
