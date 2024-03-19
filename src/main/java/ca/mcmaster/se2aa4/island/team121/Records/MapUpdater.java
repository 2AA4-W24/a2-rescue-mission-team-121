package ca.mcmaster.se2aa4.island.team121.Records;

import ca.mcmaster.se2aa4.island.team121.Heading;
import ca.mcmaster.se2aa4.island.team121.TileRecord;
import ca.mcmaster.se2aa4.island.team121.TileType;

import java.util.ArrayList;
import java.util.Map;

public interface MapUpdater {
    void updateFly();
    void updateTurn(Heading new_heading);
    void updateScan(TileRecord tile);
    void updateScanHeading(Heading heading);
    Heading getScanHeading();
}