package ca.mcmaster.se2aa4.island.team121.ModuleTests;

import ca.mcmaster.se2aa4.island.team121.Decision;
import ca.mcmaster.se2aa4.island.team121.Modules.Scanner;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ScannerTest {
    private Scanner scanner = new Scanner();
    private Decision op = Decision.SCAN;



    @Test
    void testJSONScanner() {
        JSONObject expected_json = new JSONObject();
        expected_json.put("action", "scan");
        assertTrue(expected_json.similar(scanner.getJSON()));
    }

    @Test
    void testDecisionScanner() {
        Decision scanner_decision = scanner.getDecision();
        assertSame(op, scanner_decision);
    }
}
