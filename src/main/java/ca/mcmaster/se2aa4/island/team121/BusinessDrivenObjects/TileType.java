package ca.mcmaster.se2aa4.island.team121.BusinessDrivenObjects;

import ca.mcmaster.se2aa4.island.team121.JSONParser.DefaultJSONParser;

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
