package ca.mcmaster.se2aa4.island.team121.StateTest;

import ca.mcmaster.se2aa4.island.team121.Heading;
import ca.mcmaster.se2aa4.island.team121.Records.MapUpdater;
import ca.mcmaster.se2aa4.island.team121.Records.RelativeMap;
import ca.mcmaster.se2aa4.island.team121.droneState.State;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


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
