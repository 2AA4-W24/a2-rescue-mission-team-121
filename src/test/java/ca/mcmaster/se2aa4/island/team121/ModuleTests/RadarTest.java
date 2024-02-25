package ca.mcmaster.se2aa4.island.team121.ModuleTests;
import ca.mcmaster.se2aa4.island.team121.Decision;
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
        expected_json.put("action", "echo");
        assertTrue(expected_json.similar(radar.getJSON()));
    }

    @Test
    void testDecisionRadar() {
        Decision radar_decision = radar.getDecision();
        assertSame(op, radar_decision);
    }
}
