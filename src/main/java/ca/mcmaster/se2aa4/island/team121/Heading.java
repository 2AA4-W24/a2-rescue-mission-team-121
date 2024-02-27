package ca.mcmaster.se2aa4.island.team121;

public enum Heading {
    NORTH("North"),
    SOUTH("South"),
    EAST("East"),
    WEST("West");

    private final String vector;

    private Heading(String vector) {
        this.vector = vector;
    }

    public String getVector() {
        return vector;
    }
}
