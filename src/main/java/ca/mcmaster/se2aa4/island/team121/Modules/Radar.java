package ca.mcmaster.se2aa4.island.team121.Modules;


import ca.mcmaster.se2aa4.island.team121.Action;
import ca.mcmaster.se2aa4.island.team121.Heading;
import ca.mcmaster.se2aa4.island.team121.Modules.JSONHandlers.DefaultHeadingJSONHandler;
import ca.mcmaster.se2aa4.island.team121.Modules.JSONHandlers.DefaultJSONHandler;

public class Radar extends ModuleWithHeading {

    public Radar(Heading heading) {
        super(heading);
        this.action = Action.ECHO;
        this.jsoner = new DefaultJSONHandler();
        this.heading_jsoner = new DefaultHeadingJSONHandler();
    }
}
