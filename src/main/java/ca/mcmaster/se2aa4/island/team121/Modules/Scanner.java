package ca.mcmaster.se2aa4.island.team121.Modules;

import ca.mcmaster.se2aa4.island.team121.Action;
import ca.mcmaster.se2aa4.island.team121.Modules.JSONFormatters.DefaultJSONFormatter;
import ca.mcmaster.se2aa4.island.team121.Records.MapUpdater;

public class Scanner extends Module {

    public Scanner(MapUpdater map) {
        super(map);
        this.action = Action.SCAN;
        this.jsoner = new DefaultJSONFormatter();
    }

    @Override
    public void updateMap() {
        return;
    }
}
