package ca.mcmaster.se2aa4.island.team121.modules;

import ca.mcmaster.se2aa4.island.team121.businessdrivenobjects.Action;
import ca.mcmaster.se2aa4.island.team121.modules.jsonformatters.DefaultJSONFormatter;
import ca.mcmaster.se2aa4.island.team121.records.MapUpdater;

public class Stopper extends Module {
    public Stopper(MapUpdater map) {
        super(map);
        this.action = Action.STOP;
        this.jsoner = new DefaultJSONFormatter();
    }
}
