package ca.mcmaster.se2aa4.island.team121;

import eu.ace_design.island.game.actions.Scan;

import java.util.ArrayList;
import java.util.List;

public class Record {
    private List<Decision> prevMoves = new ArrayList<Decision>();
    private int[] pos = new int[2]; //currX, currY
    private int[] attributes = new int[3]; //battery level, dist to ground, dist to base

    public void addPrevMoves()
    {
        prevMoves.add(Decision.Stop);
    }

    public void updateAttributes(int battery, int distG, int distB)
    {
        attributes[0] = battery;
        attributes[1] = distG;
        attributes[2] = distB;
    }
    public void updatePos(int x, int y)
    {
        pos[0] = x;
        pos[1] = y;
    }

    public int[] getPos()
    {
        return pos;
    }

    public int[] getAttributes()
    {
        return attributes;
    }
}
