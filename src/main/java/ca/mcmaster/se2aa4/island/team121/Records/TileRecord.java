package ca.mcmaster.se2aa4.island.team121.Records;

import ca.mcmaster.se2aa4.island.team121.Tile;

import java.util.ArrayList;
import java.util.List;

public class TileRecord {
    private List<Tile> tilesVisited = new ArrayList<Tile>();
    public void prevTiles(int x, int y)
    {
        tilesVisited.add(new Tile(x, y, null)); //Update tiletype using scanner
    }
}
