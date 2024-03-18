package ca.mcmaster.se2aa4.island.team121;
import ca.mcmaster.se2aa4.island.team121.Modules.JSONFormatters.DefaultHeadingJSONFormatter;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class DefaultHeadingJSONFormatterTest {
    @Test
    public void testAddHeading() {
        DefaultHeadingJSONFormatter formatter = new DefaultHeadingJSONFormatter();
        JSONObject json = new JSONObject();
        Heading heading = Heading.NORTH;
        JSONObject result = formatter.addHeading(json, heading);
        assertEquals(result.toString(), "{\"parameters\":{\"direction\":\"N\"}}");
    }

}
