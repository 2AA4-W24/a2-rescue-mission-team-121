package ca.mcmaster.se2aa4.island.team121.Records;

import ca.mcmaster.se2aa4.island.team121.Action;

import java.util.ArrayList;
import java.util.List;

public class MovesRecord {
    private List<Action> prevMoves = new ArrayList<Action>();

    public void add(Action d) {
        prevMoves.add(d);
    }

    public boolean movesIsEmpty() {
        return prevMoves.isEmpty();
    }

    public Action getLastMove() {
        return prevMoves.get(prevMoves.size() - 1);
    }
}
