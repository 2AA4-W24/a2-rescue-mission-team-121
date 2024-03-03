package ca.mcmaster.se2aa4.island.team121.Modules;

import ca.mcmaster.se2aa4.island.team121.Action;
import ca.mcmaster.se2aa4.island.team121.Modules.JSONHandlers.DefaultJSONHandler;

public class Scanner extends Module {
        public Scanner() {
            this.action = Action.SCAN;
            this.jsoner = new DefaultJSONHandler();
        }
}
