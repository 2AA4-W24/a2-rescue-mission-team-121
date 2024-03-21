package ca.mcmaster.se2aa4.island.team121.ModuleTests.JSONFormattersTest.JSONFormattersTest;
import ca.mcmaster.se2aa4.island.team121.BusinessDrivenObjects.Action;
import ca.mcmaster.se2aa4.island.team121.Modules.JSONFormatters.DefaultJSONFormatter;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class DefaultJSONFormatterTest {
    @Test
    public void testFormat() {
        DefaultJSONFormatter formatter = new DefaultJSONFormatter();
        Action action = Action.FLY;
        JSONObject result = formatter.format(action);
        assertEquals(result.toString(), "{\"action\":\"fly\"}");

        action = Action.ECHO;
        result = formatter.format(action);
        assertEquals(result.toString(), "{\"action\":\"echo\"}");

        action = Action.SCAN;
        result = formatter.format(action);
        assertEquals(result.toString(), "{\"action\":\"scan\"}");

        action = Action.HEADING;
        result = formatter.format(action);
        assertEquals(result.toString(), "{\"action\":\"heading\"}");

        action = Action.STOP;
        result = formatter.format(action);
        assertEquals(result.toString(), "{\"action\":\"stop\"}");
    }
}
