package ca.mcmaster.se2aa4.island.team121.moduletests;

import ca.mcmaster.se2aa4.island.team121.Action;
import ca.mcmaster.se2aa4.island.team121.Heading;
import ca.mcmaster.se2aa4.island.team121.modules.Flyer;
import ca.mcmaster.se2aa4.island.team121.records.MapUpdater;
import ca.mcmaster.se2aa4.island.team121.records.RelativeMap;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FlyerTest {

    private Flyer flyer;
    private Action action;


    @BeforeEach
    public void setUp() {
        MapUpdater map;
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