package ca.mcmaster.se2aa4.island.team121;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ca.mcmaster.se2aa4.island.team121.Records.TileRecord;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class TileRecordTest {
    private TileRecord record;
    @BeforeEach
    public void setup(){record = new TileRecord();}
    @Test
    public void TileTest()
    {
        record.prevTiles(1, 2);
        assertTrue(record.tilesVisited.get(1).getType() == null);
        assertTrue(record.tilesVisited.get(1).getX() == 1);
        assertTrue(record.tilesVisited.get(1).getY() == 2);
    }

}
