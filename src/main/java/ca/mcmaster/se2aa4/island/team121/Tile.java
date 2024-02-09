package ca.mcmaster.se2aa4.island.team121;

public class Tile {
    private final TileType type;
    private final int x;
    private final int y;

    public Tile(int x, int y, TileType type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }
    public TileType getType() {
        return type;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    
}
