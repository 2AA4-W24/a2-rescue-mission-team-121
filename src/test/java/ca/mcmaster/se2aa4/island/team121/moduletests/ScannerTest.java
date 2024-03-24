package ca.mcmaster.se2aa4.island.team121.moduletests;

import ca.mcmaster.se2aa4.island.team121.businessdrivenobjects.Action;
import ca.mcmaster.se2aa4.island.team121.businessdrivenobjects.Heading;
import ca.mcmaster.se2aa4.island.team121.modules.Scanner;
import ca.mcmaster.se2aa4.island.team121.records.MapUpdater;
import ca.mcmaster.se2aa4.island.team121.records.RelativeMap;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ScannerTest {
    private Scanner scanner;
    private Action action;


    @BeforeEach
    public void setUp() {
        MapUpdater map;
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
