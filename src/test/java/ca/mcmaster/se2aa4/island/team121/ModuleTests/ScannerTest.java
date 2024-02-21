package ca.mcmaster.se2aa4.island.team121.ModuleTests;
import ca.mcmaster.se2aa4.island.team121.Decision;
import ca.mcmaster.se2aa4.island.team121.Modules.Flyer;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class ScannerTest {
    private Flyer flyer = new Flyer();
    private String op = "fly";

    @Test
    void testJSONFlyer() {
        JSONObject expected_json = new JSONObject();
        expected_json.put("action", op);

        assertTrue(expected_json.similar(flyer.getJSON()));
    }

    @Test
    void testDecisionFlyer() {
        Decision flyer_decision = flyer.getDecision();
        assertEquals(op, flyer_decision.getName());
    }
}
