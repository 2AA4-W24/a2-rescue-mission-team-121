package ca.mcmaster.se2aa4.island.team121.statetest;

import ca.mcmaster.se2aa4.island.team121.Heading;
import ca.mcmaster.se2aa4.island.team121.dronestate.State;
import ca.mcmaster.se2aa4.island.team121.records.MapUpdater;
import ca.mcmaster.se2aa4.island.team121.records.RelativeMap;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;


class TestingState extends State {
    public TestingState(MapUpdater map) {
        super(map);
    }

    @Override
    public State getNext() {
        return null;
    }

    @Override
    public void update(JSONObject json) {

    }
}

public class StateTest {
    @BeforeEach
    public void setup() {
        MapUpdater map = new RelativeMap(Heading.NORTH);
        State state = new TestingState(map);
    }
    @Test
    public void testIsGoNext() {
        MapUpdater map = new RelativeMap(Heading.NORTH);
        State state = new TestingState(map);
        assertFalse(state.isGoNext());
    }
    @Test
    public void testExecute() {
        MapUpdater map = new RelativeMap(Heading.NORTH);
        State state = new TestingState(map);
    }
    @Test
    public void testGetNext() {
        MapUpdater map = new RelativeMap(Heading.NORTH);
        State state = new TestingState(map);
        assertNull(state.getNext());
    }
    @Test
    public void testUpdate() {
        MapUpdater map = new RelativeMap(Heading.NORTH);
        State state = new TestingState(map);
        JSONObject json = new JSONObject();
        state.update(json);
    }

}
