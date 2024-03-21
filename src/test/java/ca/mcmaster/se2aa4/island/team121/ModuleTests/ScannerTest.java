package ca.mcmaster.se2aa4.island.team121.ModuleTests;

import ca.mcmaster.se2aa4.island.team121.BusinessDrivenObjects.Action;
import ca.mcmaster.se2aa4.island.team121.BusinessDrivenObjects.Heading;
import ca.mcmaster.se2aa4.island.team121.Modules.Scanner;
import ca.mcmaster.se2aa4.island.team121.Records.MapUpdater;
import ca.mcmaster.se2aa4.island.team121.Records.RelativeMap;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ScannerTest {
    private Scanner scanner;
    private Action action;
    private MapUpdater map;

    @BeforeEach
    public void setUp() {
        map = new RelativeMap(Heading.EAST);
        scanner = new Scanner(map);
        action = Action.SCAN;
    }

    @Test
    void testGetJSON() {
        JSONObject expected_json = new JSONObject();
        expected_json.put("action", action.getName());

        assertTrue(expected_json.similar(scanner.getJSON()));
    }
}
