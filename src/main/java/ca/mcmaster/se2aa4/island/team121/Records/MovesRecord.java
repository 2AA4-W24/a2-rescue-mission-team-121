package ca.mcmaster.se2aa4.island.team121.Records;

import ca.mcmaster.se2aa4.island.team121.Decision;

import java.util.ArrayList;
import java.util.List;

public class MovesRecord<T> {
    private List<Decision> prevMoves = new ArrayList<Decision>();
    public void add(Decision d)
    {
        prevMoves.add(d);
    }
    public boolean movesIsEmpty()
    {
        return prevMoves.isEmpty();
    }
    public Decision getLastMove()
    {
        return prevMoves.get(prevMoves.size()-1);
    }
}
