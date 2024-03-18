package ca.mcmaster.se2aa4.island.team121;

import ca.mcmaster.se2aa4.island.team121.DroneState.JSONParser.DefaultJSONParser;
import org.json.JSONObject;

public enum TileType {
    SITE, CREEK, UNKNOWN;

    private DefaultJSONParser parser;

    public static TileType TileTypeOf(String type) {
        switch (type) {
            case "SITE" -> {
                return SITE;
            }
            case "CREEK" -> {
                return CREEK;
            }
            default -> {
                return UNKNOWN;
            }
        }
    }



}
