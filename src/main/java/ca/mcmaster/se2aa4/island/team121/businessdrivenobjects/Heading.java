package ca.mcmaster.se2aa4.island.team121.businessdrivenobjects;

public enum Heading {
  
    NORTH("N"),
    SOUTH("S"),
    EAST("E"),
    WEST("W");

    private final String vector;

    private Heading(String vector) {
        this.vector = vector;
    }

    public String getVector() {
        return vector;
    }

    public static Heading headingOf(String direction) {
        switch (direction) {
            case "N","NORTH" -> {
                return NORTH;
            }
            case "S","SOUTH" -> {
                return SOUTH;
            }
            case "E","EAST" -> {
                return EAST;
            }
            case "W","WEST" -> {
                return WEST;
            }
            default -> throw new IllegalArgumentException("Invalid direction: " + direction);

        }
    }
}
