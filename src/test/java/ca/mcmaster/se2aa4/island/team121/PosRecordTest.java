package ca.mcmaster.se2aa4.island.team121;

import ca.mcmaster.se2aa4.island.team121.Records.PosRecord;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PosRecordTest {
    private PosRecord record;
    @BeforeEach
    public void setup(){record = new PosRecord();}

    @Test
    public void posTest()
    {
        record.updatePos(1,2);
        assertTrue(record.pos[1] == 1);
        assertTrue(record.pos[2] ==2);
    }
}
