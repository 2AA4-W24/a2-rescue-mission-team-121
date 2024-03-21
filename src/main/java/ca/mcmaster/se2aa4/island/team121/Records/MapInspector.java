package ca.mcmaster.se2aa4.island.team121.Records;

import ca.mcmaster.se2aa4.island.team121.BusinessDrivenObjects.TileRecord;

import java.util.Map;

public interface MapInspector {
    void displayMap();
    Map<TileRecord, Double> getCreekSiteDistances();
}
