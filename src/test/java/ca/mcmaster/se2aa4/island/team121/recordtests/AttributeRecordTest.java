package ca.mcmaster.se2aa4.island.team121.recordtests;

import ca.mcmaster.se2aa4.island.team121.records.AttributeRecord;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class AttributeRecordTest {

    private AttributeRecord record;

    @BeforeEach
    public void setup() {
        record = new AttributeRecord();
    }

    @Test
    public void attributeTest() {
        record.updateAttributes(1);
        Map<String, Integer> map = record.getAttributes();
        int battery_level = map.get("battery_level");
        assertEquals(1, battery_level);
    }

}
