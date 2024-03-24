package ca.mcmaster.se2aa4.island.team121.records;

import ca.mcmaster.se2aa4.island.team121.businessdrivenobjects.TileRecord;

import java.util.Map;

public interface MapInspector {
    void displayMap();
    Map<TileRecord, Double> getCreekSiteDistances();
}
