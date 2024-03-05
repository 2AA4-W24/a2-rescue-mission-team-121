package ca.mcmaster.se2aa4.island.team121.Modules;

import ca.mcmaster.se2aa4.island.team121.Action;
import ca.mcmaster.se2aa4.island.team121.Modules.JSONHandlers.DefaultJSONHandler;

public class Flyer extends Module {
    public Flyer() {
        this.action = Action.FLY;
        this.jsoner = new DefaultJSONHandler();
    }
}
