package ca.mcmaster.se2aa4.island.team121.businessdrivenobjects;

import ca.mcmaster.se2aa4.island.team121.jsonparser.DefaultJSONParser;

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
