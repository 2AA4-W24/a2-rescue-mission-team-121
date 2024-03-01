package ca.mcmaster.se2aa4.island.team121;

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
            case "N" -> {
                return NORTH;
            }
            case "S" -> {
                return SOUTH;
            }
            case "E" -> {
                return EAST;
            }
            case "W" -> {
                return WEST;
            }
            default -> throw new IllegalArgumentException("Invalid direction: " + direction);

        }
    }
}
