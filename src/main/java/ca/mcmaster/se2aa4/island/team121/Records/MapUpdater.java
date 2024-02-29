package ca.mcmaster.se2aa4.island.team121.Records;

import ca.mcmaster.se2aa4.island.team121.Heading;
import ca.mcmaster.se2aa4.island.team121.TileType;

public interface MapUpdater {
    void updateFly();

    void updateTurn(Heading new_heading);

    void updateScan(TileType new_type);

    boolean isOverGound();
}