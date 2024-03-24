package ca.mcmaster.se2aa4.island.team121.records;

import ca.mcmaster.se2aa4.island.team121.businessdrivenobjects.Heading;
import ca.mcmaster.se2aa4.island.team121.businessdrivenobjects.TileRecord;

public interface MapUpdater {
    void updateFly();
    void updateTurn(Heading new_heading);
    void updateScan(TileRecord tile);
    void updateScanHeading(Heading heading);
    Heading getScanHeading();
}