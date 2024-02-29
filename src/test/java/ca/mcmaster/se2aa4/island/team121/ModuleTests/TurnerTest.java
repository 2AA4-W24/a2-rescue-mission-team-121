package ca.mcmaster.se2aa4.island.team121.ModuleTests;

import ca.mcmaster.se2aa4.island.team121.Decision;
import ca.mcmaster.se2aa4.island.team121.Heading;
import ca.mcmaster.se2aa4.island.team121.Modules.Turner;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TurnerTest {
    private Turner turner = new Turner();
    private Decision op = Decision.HEADING;

    @Test
    void testJSONTurner() {
        JSONObject expected_json = new JSONObject();
        expected_json.put("action", op.getName());
        expected_json.put("parameters", new JSONObject().put("direction", "N"));

        assertTrue(expected_json.similar(turner.getJSON(Heading.NORTH)));
    }
}
