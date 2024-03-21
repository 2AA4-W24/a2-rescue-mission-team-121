package ca.mcmaster.se2aa4.island.team121.Records;

import java.util.HashMap;
import java.util.Map;

public class AttributeRecord {
    private Map<String, Integer> attributes = new HashMap<>(); //battery level, dist to ground, dist to base

    public void updateAttributes(int battery)
    {
        attributes.put("battery_level", battery);
    }
    public Map<String, Integer> getAttributes()
    {
        return attributes;
    }
    public int getBattery(){return attributes.get("battery_level");}
}
