package ca.mcmaster.se2aa4.island.team121.DroneState;

import ca.mcmaster.se2aa4.island.team121.Action;
import ca.mcmaster.se2aa4.island.team121.Heading;
import ca.mcmaster.se2aa4.island.team121.Modules.Flyer;
import ca.mcmaster.se2aa4.island.team121.Modules.Radar;
import ca.mcmaster.se2aa4.island.team121.Modules.Scanner;
import ca.mcmaster.se2aa4.island.team121.Records.AttributeRecord;
import ca.mcmaster.se2aa4.island.team121.Records.MovesRecord;
import ca.mcmaster.se2aa4.island.team121.Records.RelativeMap;
import org.json.JSONObject;

public class Start {
    Radar radar = new Radar(Heading.SOUTH);
    Flyer fly = new Flyer();
    private MovesRecord moves = new MovesRecord();
    private RelativeMap map = new RelativeMap(Heading.EAST);
    private Action next_action;
    JSONObject decison = new JSONObject();

    public JSONObject makeDecision()
    {
        if(moves.movesIsEmpty())
        {
            
        }
    }



}
