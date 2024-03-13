package ca.mcmaster.se2aa4.island.team121.Modules;

import ca.mcmaster.se2aa4.island.team121.Action;
import ca.mcmaster.se2aa4.island.team121.Modules.JSONFormatters.DefaultJSONFormatter;
import ca.mcmaster.se2aa4.island.team121.Records.MapUpdater;

public class Stopper extends Module {
    public Stopper(MapUpdater map) {
        super(map);
        this.action = Action.STOP;
        this.jsoner = new DefaultJSONFormatter();
    }
}
