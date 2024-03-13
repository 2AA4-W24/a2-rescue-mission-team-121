package ca.mcmaster.se2aa4.island.team121.Modules;


import ca.mcmaster.se2aa4.island.team121.Action;
import ca.mcmaster.se2aa4.island.team121.Heading;
import ca.mcmaster.se2aa4.island.team121.Modules.JSONFormatters.DefaultHeadingJSONFormatter;
import ca.mcmaster.se2aa4.island.team121.Modules.JSONFormatters.DefaultJSONFormatter;
import ca.mcmaster.se2aa4.island.team121.Records.MapUpdater;

public class Radar extends ModuleWithHeading {

    public Radar(MapUpdater map, Heading heading) {
        super(map, heading);
        this.action = Action.ECHO;
        this.jsoner = new DefaultJSONFormatter();
        this.heading_jsoner = new DefaultHeadingJSONFormatter();
    }

    @Override
    public void updateMap() {
        return;
    }
}
