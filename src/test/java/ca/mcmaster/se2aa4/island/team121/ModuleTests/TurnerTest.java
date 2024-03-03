package ca.mcmaster.se2aa4.island.team121.ModuleTests;

import ca.mcmaster.se2aa4.island.team121.Action;
import ca.mcmaster.se2aa4.island.team121.Heading;
import ca.mcmaster.se2aa4.island.team121.Modules.Turner;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TurnerTest {

    private Heading input_heading;
    private Turner turner;
    private Action action;

    @BeforeEach
    public void setUp() {
        input_heading = Heading.SOUTH;
        turner = new Turner(input_heading);
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
