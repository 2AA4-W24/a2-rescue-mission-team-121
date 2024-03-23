package ca.mcmaster.se2aa4.island.team121.StateTest;

import ca.mcmaster.se2aa4.island.team121.DroneState.State;
import ca.mcmaster.se2aa4.island.team121.DroneState.Stop;
import ca.mcmaster.se2aa4.island.team121.Modules.Flyer;
import ca.mcmaster.se2aa4.island.team121.Modules.Radar;
import ca.mcmaster.se2aa4.island.team121.Modules.Scanner;
import ca.mcmaster.se2aa4.island.team121.Modules.Turner;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import ca.mcmaster.se2aa4.island.team121.Records.MapUpdater;
import ca.mcmaster.se2aa4.island.team121.Records.RelativeMap;
import ca.mcmaster.se2aa4.island.team121.BusinessDrivenObjects.Heading;


class TestingState extends State {
    public TestingState(MapUpdater map) {
        super(map);
        this.cycle.add(new Flyer(map));
        this.cycle.add(new Turner(map, Heading.NORTH));
    }

    @Override
    public State getNext() {
        return new Stop(map);
    }

    @Override
    public void update(JSONObject json) {
        go_next = true;
    }
}

public class StateTest {

    State state;

    @BeforeEach
    public void setup() {
        MapUpdater map = new RelativeMap(Heading.EAST);
        state = new TestingState(map);
    }

    @Test
    public void testExecuteCycle() {
        JSONObject expected_json = new JSONObject().put("action", "fly");
        assertTrue(expected_json.similar(state.execute()));
        expected_json = new JSONObject().put("action", "heading");
        expected_json.put("parameters", new JSONObject().put("direction", "N"));
        assertTrue(expected_json.similar(state.execute()));
    }

    @Test
    public void testUpdate() {
        state.update(new JSONObject());
        assertEquals(true, state.isGoNext());
    }
}
