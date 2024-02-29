package ca.mcmaster.se2aa4.island.team121.ModuleTests;

import ca.mcmaster.se2aa4.island.team121.Decision;
import ca.mcmaster.se2aa4.island.team121.Heading;
import ca.mcmaster.se2aa4.island.team121.Modules.Radar;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RadarTest {

    private Radar radar = new Radar();
    private Decision op = Decision.ECHO;

    @Test
    void testJSONRadar() {
        JSONObject expected_json = new JSONObject();
        expected_json.put("action", op.getName());
        expected_json.put("parameters", new JSONObject().put("direction", "N"));
        assertTrue(expected_json.similar(radar.getJSON(Heading.NORTH)));
    }
}
