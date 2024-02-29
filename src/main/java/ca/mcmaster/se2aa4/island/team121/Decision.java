package ca.mcmaster.se2aa4.island.team121;

public enum Decision {
    FLY("fly"),
    SCAN("scan"),
    STOP("stop"),
    HEADING("heading"),
    ECHO("echo");

    private final String name;

    private Decision(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
