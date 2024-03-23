package ca.mcmaster.se2aa4.island.team121.Modules;

import ca.mcmaster.se2aa4.island.team121.Action;
import ca.mcmaster.se2aa4.island.team121.Heading;
import ca.mcmaster.se2aa4.island.team121.Modules.JSONFormatters.DefaultHeadingJSONFormatter;
import ca.mcmaster.se2aa4.island.team121.Modules.JSONFormatters.DefaultJSONFormatter;
import ca.mcmaster.se2aa4.island.team121.Records.MapUpdater;

public class Turner extends ModuleWithHeading {

    public Turner(MapUpdater map, Heading heading) {
        super(map, heading);
        this.action = Action.HEADING;
        this.jsoner = new DefaultJSONFormatter();
        this.heading_jsoner = new DefaultHeadingJSONFormatter();
    }

    @Override
    public void updateMap() {
        map.updateTurn(heading);
    }
}
