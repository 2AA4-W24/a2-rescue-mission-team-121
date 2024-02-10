package ca.mcmaster.se2aa4.island.team121;

import eu.ace_design.island.game.actions.Scan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Record {
    private List<Decision> prevMoves = new ArrayList<Decision>();

    private List<Tile> tilesVisited = new ArrayList<Tile>();
    private int[] pos = new int[2]; //currX, currY
    private Map<String, Integer> attributes = new HashMap<>(); //battery level, dist to ground, dist to base
    public void addPrevMoves()
    {
        prevMoves.add(Decision.STOP);
    }


    public void updateAttributes(int battery, int distG, int distB)
    {
        attributes.put("battery_level", battery);
        attributes.put("ground_distance", distG);
        attributes.put("base_distance", distB);
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

    public Map<String, Integer> getAttributes()
    {
        return attributes;
    }

    public Decision getLastMove()
    {
        return prevMoves.get(prevMoves.size()-1);
    }

    public void prevTiles()
    {
        tilesVisited.add(new Tile(pos[0], pos[1], null)); //Update tiletype using scanner
    }
}
