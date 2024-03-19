package ca.mcmaster.se2aa4.island.team121.StateTest;
import ca.mcmaster.se2aa4.island.team121.TileRecord;
import ca.mcmaster.se2aa4.island.team121.TileType;
import java.util.List;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TileRecordTest {
    @Test
    public void testTileRecord() {
        TileRecord tileRecord = new TileRecord(TileType.SITE, List.of("1agsfytaa", "2sdadg"));
        assertEquals(TileType.SITE, tileRecord.type());
        assertEquals(List.of("1agsfytaa", "2sdadg"), tileRecord.id());

        tileRecord = new TileRecord(TileType.CREEK, List.of("1agsfytaa"));
        assertEquals(TileType.CREEK, tileRecord.type());
        assertEquals(List.of("1agsfytaa"), tileRecord.id());

    }
}
