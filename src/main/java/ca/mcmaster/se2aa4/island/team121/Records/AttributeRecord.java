package ca.mcmaster.se2aa4.island.team121.Records;

import java.util.HashMap;
import java.util.Map;

public class AttributeRecord {
    private Map<String, Integer> attributes = new HashMap<>(); //battery level, dist to ground, dist to base

    public void updateAttributes(int battery, int distG, int distB)
    {
        attributes.put("battery_level", battery);
        attributes.put("ground_distance", distG);
        attributes.put("base_distance", distB);
    }
    public Map<String, Integer> getAttributes()
    {
        return attributes;
    }

    public int getDistG(){return attributes.get("ground_distance");}
    public int getDistB(){return attributes.get("base_distance");}
    public int getBattery(){return attributes.get("battery_level");}
}
