package ca.mcmaster.se2aa4.island.team121;

public enum TileType {
    GROUND, WATER, SITE, CREEK, UNKNOWN

    public static TileType TileTypeOf(String type) {
        switch (type) {
            case "GROUND" -> {
                return GROUND;
            }
            case "OCEAN" -> {
                return WATER;
            }
            case "SITE" -> {
                return SITE;
            }
            case "CREEK" -> {
                return CREEK;
            }
            default -> throw new IllegalArgumentException("Invalid type: " + type);
        }
    }
}
