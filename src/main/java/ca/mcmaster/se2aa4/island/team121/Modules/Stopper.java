package ca.mcmaster.se2aa4.island.team121.Modules;

import ca.mcmaster.se2aa4.island.team121.Action;
import ca.mcmaster.se2aa4.island.team121.Modules.JSONHandlers.DefaultJSONHandler;

public class Stopper extends Module {
    public Stopper() {
        this.action = Action.STOP;
        this.jsoner = new DefaultJSONHandler();
    }
}
