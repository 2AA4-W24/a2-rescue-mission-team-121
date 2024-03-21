package ca.mcmaster.se2aa4.island.team121.BusinessDrivenObjects;

public enum Action {
    FLY("fly"),
    SCAN("scan"),
    STOP("stop"),
    HEADING("heading"),
    ECHO("echo");

    private final String name;

    private Action(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
