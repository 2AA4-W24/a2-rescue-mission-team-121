package ca.mcmaster.se2aa4.island.team121.DroneState;

public enum State {
    Start("S"),
    look4Ground("l4g"),
    flyToBeach("f2b"),
    onBeach("ob"),
    islandSearch("search"),
    emergSiteFound("emerg"),
    exit("exit");


    private final String name;

    private State(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
