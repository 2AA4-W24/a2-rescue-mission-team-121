package ca.mcmaster.se2aa4.island.team121.statetest;

import ca.mcmaster.se2aa4.island.team121.dronestate.State;
import ca.mcmaster.se2aa4.island.team121.dronestate.Stop;
import ca.mcmaster.se2aa4.island.team121.modules.Flyer;
import ca.mcmaster.se2aa4.island.team121.modules.Turner;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import ca.mcmaster.se2aa4.island.team121.records.MapUpdater;
import ca.mcmaster.se2aa4.island.team121.records.RelativeMap;
import ca.mcmaster.se2aa4.island.team121.businessdrivenobjects.Heading;


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
