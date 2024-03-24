package ca.mcmaster.se2aa4.island.team121.moduletests;

import ca.mcmaster.se2aa4.island.team121.businessdrivenobjects.Action;
import ca.mcmaster.se2aa4.island.team121.businessdrivenobjects.Heading;
import ca.mcmaster.se2aa4.island.team121.modules.Turner;
import ca.mcmaster.se2aa4.island.team121.records.MapUpdater;
import ca.mcmaster.se2aa4.island.team121.records.RelativeMap;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TurnerTest {

    private Heading input_heading;
    private Turner turner;
    private Action action;
    private MapUpdater map;

    @BeforeEach
    public void setUp() {
        map = new RelativeMap(Heading.EAST);
        input_heading = Heading.SOUTH;
        turner = new Turner(map, input_heading);
        action = Action.HEADING;
    }

    @Test
    void testGetJSON() {
        JSONObject expected_json = new JSONObject();
        expected_json.put("action", action.getName());
        expected_json.put("parameters", new JSONObject().put("direction", input_heading.getVector()));

        assertTrue(expected_json.similar(turner.getJSON()));
    }
}
