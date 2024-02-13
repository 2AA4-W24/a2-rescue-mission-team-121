package ca.mcmaster.se2aa4.island.team121.Records;

public class PosRecord {
    private int[] pos = new int[2]; //currX, currY
    public void updatePos(int x, int y)
    {
        pos[0] = x;
        pos[1] = y;
    }
    public int[] getPos()
    {
        return pos;
    }
}
