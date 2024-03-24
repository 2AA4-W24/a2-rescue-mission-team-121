package ca.mcmaster.se2aa4.island.team121.moduletests;

import ca.mcmaster.se2aa4.island.team121.businessdrivenobjects.Action;
import ca.mcmaster.se2aa4.island.team121.businessdrivenobjects.Heading;
import ca.mcmaster.se2aa4.island.team121.modules.Flyer;
import ca.mcmaster.se2aa4.island.team121.records.MapUpdater;
import ca.mcmaster.se2aa4.island.team121.records.RelativeMap;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FlyerTest {

    private Flyer flyer;
    private Action action;
    private MapUpdater map;

    @BeforeEach
    public void setUp() {
        map = new RelativeMap(Heading.EAST);
        flyer = new Flyer(map);
        action = Action.FLY;
    }

    @Test
    void testGetJSON() {
        JSONObject expected_json = new JSONObject();
        expected_json.put("action", action.getName());

        assertTrue(expected_json.similar(flyer.getJSON()));
    }

}
