package ca.mcmaster.se2aa4.island.team121.moduletests.jsonformattertest;

import ca.mcmaster.se2aa4.island.team121.businessdrivenobjects.Heading;
import ca.mcmaster.se2aa4.island.team121.modules.jsonformatters.DefaultHeadingJSONFormatter;
import org.json.JSONObject;
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
