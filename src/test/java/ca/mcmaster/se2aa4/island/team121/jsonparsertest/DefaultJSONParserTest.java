package ca.mcmaster.se2aa4.island.team121.jsonparsertest;

import ca.mcmaster.se2aa4.island.team121.jsonparser.DefaultJSONParser;
import ca.mcmaster.se2aa4.island.team121.businessdrivenobjects.TileType;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class DefaultJSONParserTest {

    JSONObject response_creek = new JSONObject();
    JSONObject response_site = new JSONObject();
    JSONObject response_unknown = new JSONObject();
    JSONObject response_ground = new JSONObject();
    JSONObject response_OOR = new JSONObject();
    DefaultJSONParser default_JSON_parser = new DefaultJSONParser();

    @BeforeEach
    void setUp() {

        JSONObject extras_creek = new JSONObject();
        extras_creek.put("creeks", new JSONArray().put("6a95fbfc-fe87-459a-9f70-bc04a9c0d5f3"));
        extras_creek.put("biomes", new JSONArray().put("MANGROVE"));
        extras_creek.put("sites", new JSONArray());

        JSONObject extras_site = new JSONObject();
        extras_site.put("creeks", new JSONArray());
        extras_site.put("biomes", new JSONArray().put("MANGROVE"));
        extras_site.put("sites", new JSONArray().put("6a95fbfc-fe87-459a-9f70-bc04a9c0d5f3"));

        JSONObject extras_unknown = new JSONObject();
        extras_unknown.put("creeks", new JSONArray());
        extras_unknown.put("biomes", new JSONArray());
        extras_unknown.put("sites", new JSONArray());

        JSONObject extras_ground = new JSONObject();
        extras_ground.put("found", "GROUND");
        extras_ground.put("range", 9);

        JSONObject extras_OOR = new JSONObject();
        extras_OOR.put("found", "OUT_OF_RANGE");
        extras_OOR.put("range", 8);


        // Create the main JSON object
        response_creek.put("cost", 6);
        response_creek.put("extras", extras_creek);
        response_creek.put("status", "OK");

        response_site.put("cost", 6);
        response_site.put("extras", extras_site);
        response_site.put("status", "OK");

        response_unknown.put("cost", 6);
        response_unknown.put("extras", extras_unknown);
        response_unknown.put("status", "OK");

        response_ground.put("cost", 6);
        response_ground.put("extras", extras_ground);
        response_ground.put("status", "OK");

        response_OOR.put("cost", 6);
        response_OOR.put("extras", extras_OOR);
        response_OOR.put("status", "OK");


    }

    @Test
    void testGetScan() {
        JSONObject empty = new JSONObject();
        Assertions.assertEquals(TileType.UNKNOWN, default_JSON_parser.getScan(empty));
        assertEquals(TileType.UNKNOWN, default_JSON_parser.getScan((response_unknown)));
        assertEquals(TileType.CREEK, default_JSON_parser.getScan(response_creek));
        assertEquals(TileType.SITE, default_JSON_parser.getScan(response_site));
    }

    @Test
    void testEchoGround() {
        JSONObject empty = new JSONObject();
        assertEquals("NO_SCAN", default_JSON_parser.echoGround(empty));
        assertEquals("GROUND", default_JSON_parser.echoGround(response_ground));
        assertEquals("OUT_OF_RANGE", default_JSON_parser.echoGround(response_OOR));

    }

    @Test
    void testEchoDistance() {
        JSONObject empty = new JSONObject();
        assertEquals(-1, default_JSON_parser.echoDistance(empty));
        assertEquals(9, default_JSON_parser.echoDistance(response_ground));
        assertEquals(8, default_JSON_parser.echoDistance(response_OOR));
    }

    @Test
    void testGetCost() {
        JSONObject empty = new JSONObject();
        assertEquals(-1, default_JSON_parser.getCost(empty));
        assertEquals(6, default_JSON_parser.getCost(response_ground));
    }

    @Test
    void testGetId() {
        JSONObject empty = new JSONObject();
        ArrayList<String> Ids = new ArrayList<String>();
        assertEquals(Ids, default_JSON_parser.getId(empty));
        assertEquals(Ids, default_JSON_parser.getId(response_unknown));
        assertEquals(Ids, default_JSON_parser.getId(response_ground));
        assertEquals(Ids, default_JSON_parser.getId(response_OOR));
        Ids.add("6a95fbfc-fe87-459a-9f70-bc04a9c0d5f3");
        assertEquals(Ids, default_JSON_parser.getId(response_creek));
        assertEquals(Ids, default_JSON_parser.getId(response_site));

    }

}
