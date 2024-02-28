package ca.mcmaster.se2aa4.island.team121.ModuleTests;

import ca.mcmaster.se2aa4.island.team121.Decision;
import ca.mcmaster.se2aa4.island.team121.Modules.Turner;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TurnerTest {
    private Turner turner = new Turner();
    private Decision op = Decision.TURN;

    @Test
    void testJSONTurner() {
        JSONObject expected_json = new JSONObject();
        expected_json.put("action", "turn");
        assertTrue(expected_json.similar(turner.getJSON()));
    }

    @Test
    void testDecisionTurner() {
        Decision turner_decision = turner.getDecision();
        assertSame(op, turner_decision);
    }
}
