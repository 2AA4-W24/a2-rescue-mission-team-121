package ca.mcmaster.se2aa4.island.team121.modules;
import ca.mcmaster.se2aa4.island.team121.businessdrivenobjects.Action;
import ca.mcmaster.se2aa4.island.team121.businessdrivenobjects.Heading;
import ca.mcmaster.se2aa4.island.team121.modules.jsonformatters.DefaultHeadingJSONFormatter;
import ca.mcmaster.se2aa4.island.team121.modules.jsonformatters.DefaultJSONFormatter;
import ca.mcmaster.se2aa4.island.team121.records.MapUpdater;

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
