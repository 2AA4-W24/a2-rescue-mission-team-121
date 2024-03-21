package ca.mcmaster.se2aa4.island.team121.Modules;

import ca.mcmaster.se2aa4.island.team121.BusinessDrivenObjects.Action;
import ca.mcmaster.se2aa4.island.team121.Modules.JSONFormatters.DefaultJSONFormatter;
import ca.mcmaster.se2aa4.island.team121.Records.MapUpdater;

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
