package ca.mcmaster.se2aa4.island.team121;

public enum Action {
    FLY("fly"),
    SCAN("scan"),
    STOP("stop"),
    HEADING("heading"),
    ECHO("echo");

    private final String name;

    Action(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
