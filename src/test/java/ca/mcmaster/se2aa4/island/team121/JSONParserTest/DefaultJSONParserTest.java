package ca.mcmaster.se2aa4.island.team121.JSONParserTest;

import ca.mcmaster.se2aa4.island.team121.TileType;
import ca.mcmaster.se2aa4.island.team121.droneState.JSONParser.DefaultJSONParser;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DefaultJSONParserTest {

    final JSONObject responseCreek = new JSONObject();
    final JSONObject responseSite = new JSONObject();
    final JSONObject responseUnknown = new JSONObject();
    final JSONObject responseGround = new JSONObject();
    final JSONObject responseOOR = new JSONObject();
    final DefaultJSONParser defaultJSONParser = new DefaultJSONParser();

    @BeforeEach
    void setUp() {

        JSONObject extrasCreek = new JSONObject();
        extrasCreek.put("creeks", new JSONArray().put("6a95fbfc-fe87-459a-9f70-bc04a9c0d5f3"));
        extrasCreek.put("biomes", new JSONArray().put("MANGROVE"));
        extrasCreek.put("sites", new JSONArray());

        JSONObject extrasSite = new JSONObject();
        extrasSite.put("creeks", new JSONArray());
        extrasSite.put("biomes", new JSONArray().put("MANGROVE"));
        extrasSite.put("sites", new JSONArray().put("6a95fbfc-fe87-459a-9f70-bc04a9c0d5f3"));

        JSONObject extrasUnknown = new JSONObject();
        extrasUnknown.put("creeks", new JSONArray());
        extrasUnknown.put("biomes", new JSONArray());
        extrasUnknown.put("sites", new JSONArray());

        JSONObject extrasGround = new JSONObject();
        extrasGround.put("found", "GROUND");
        extrasGround.put("range", 9);

        JSONObject extrasOOR = new JSONObject();
        extrasOOR.put("found", "OUT_OF_RANGE");
        extrasOOR.put("range", 8);


        // Create the main JSON object
        responseCreek.put("cost", 6);
        responseCreek.put("extras", extrasCreek);
        responseCreek.put("status", "OK");

        responseSite.put("cost", 6);
        responseSite.put("extras", extrasSite);
        responseSite.put("status", "OK");

        responseUnknown.put("cost", 6);
        responseUnknown.put("extras", extrasUnknown);
        responseUnknown.put("status", "OK");

        responseGround.put("cost", 6);
        responseGround.put("extras", extrasGround);
        responseGround.put("status", "OK");

        responseOOR.put("cost", 6);
        responseOOR.put("extras", extrasOOR);
        responseOOR.put("status", "OK");


    }

    @Test
    void testGetScan() {
        JSONObject empty = new JSONObject();
        Assertions.assertEquals(TileType.UNKNOWN, defaultJSONParser.getScan(empty));
        assertEquals(TileType.UNKNOWN, defaultJSONParser.getScan((responseUnknown)));
        assertEquals(TileType.CREEK, defaultJSONParser.getScan(responseCreek));
        assertEquals(TileType.SITE, defaultJSONParser.getScan(responseSite));
    }

    @Test
    void testEchoGround() {
        JSONObject empty = new JSONObject();
        assertEquals("NO_SCAN", defaultJSONParser.echoGround(empty));
        assertEquals("GROUND", defaultJSONParser.echoGround(responseGround));
        assertEquals("OUT_OF_RANGE", defaultJSONParser.echoGround(responseOOR));

    }

    @Test
    void testEchoDistance() {
        JSONObject empty = new JSONObject();
        assertEquals(-1, defaultJSONParser.echoDistance(empty));
        assertEquals(9, defaultJSONParser.echoDistance(responseGround));
        assertEquals(8, defaultJSONParser.echoDistance(responseOOR));
    }

    @Test
    void testGetCost() {
        JSONObject empty = new JSONObject();
        assertEquals(-1, defaultJSONParser.getCost(empty));
        assertEquals(6, defaultJSONParser.getCost(responseGround));
    }

    @Test
    void testGetId() {
        JSONObject empty = new JSONObject();
        ArrayList<String> Ids = new ArrayList<>();
        assertEquals(Ids, defaultJSONParser.getId(empty));
        assertEquals(Ids, defaultJSONParser.getId(responseUnknown));
        assertEquals(Ids, defaultJSONParser.getId(responseGround));
        assertEquals(Ids, defaultJSONParser.getId(responseOOR));
        Ids.add("6a95fbfc-fe87-459a-9f70-bc04a9c0d5f3");
        assertEquals(Ids, defaultJSONParser.getId(responseCreek));
        assertEquals(Ids, defaultJSONParser.getId(responseSite));

    }

}
