package ca.mcmaster.se2aa4.island.team121;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import ca.mcmaster.se2aa4.island.team121.Records.MovesRecord;

public class MovesRecordTest {

    private MovesRecord record;


    @BeforeEach
    public void setup(){record = new MovesRecord();}

    @Test
    public void emptyRecord()
    {
        boolean empty = record.movesIsEmpty();
        assertFalse(empty);
    }

    public void fullRecord()
    {
        record.addPrevMoves();
        record.addPrevMoves();
        Decision lastMove = record.getLastMove();
        assertEquals(Decision.STOP, lastMove);
    }

}
