package ca.mcmaster.se2aa4.island.team121.businessdrivenobjects;

public enum TileType {
    SITE, CREEK, UNKNOWN;

    public static TileType tiletypeOf(String type) {
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
