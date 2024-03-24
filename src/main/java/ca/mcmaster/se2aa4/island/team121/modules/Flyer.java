package ca.mcmaster.se2aa4.island.team121.modules;

import ca.mcmaster.se2aa4.island.team121.businessdrivenobjects.Action;
import ca.mcmaster.se2aa4.island.team121.modules.jsonformatters.DefaultJSONFormatter;
import ca.mcmaster.se2aa4.island.team121.records.MapUpdater;

public class Flyer extends Module {

    public Flyer(MapUpdater map) {
        super(map);
        this.action = Action.FLY;
        this.jsoner = new DefaultJSONFormatter();
    }

    @Override
    public void updateMap() {
        map.updateFly();
    }
}
