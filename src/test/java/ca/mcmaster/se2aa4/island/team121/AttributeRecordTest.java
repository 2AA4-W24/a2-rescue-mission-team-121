package ca.mcmaster.se2aa4.island.team121;

import ca.mcmaster.se2aa4.island.team121.Records.AttributeRecord;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;



public class AttributeRecordTest  {
    @Test
    public void attributeTest()
    {
        AttributeRecord record = new AttributeRecord();
        record.updateAttributes(1,2,3);
        Map<String, Integer> map =  record.getAttributes();
        int battery_level = map.get("battery_level");
        int ground_distance = map.get("ground_distance");
        int base_distance = map.get("base_distance");
        assertEquals(1, battery_level);
        assertEquals(2, ground_distance);
        assertEquals(3, base_distance);
    }


}