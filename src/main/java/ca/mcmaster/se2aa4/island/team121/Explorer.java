package ca.mcmaster.se2aa4.island.team121;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import ca.mcmaster.se2aa4.island.team121.Records.AttributeRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import eu.ace_design.island.bot.IExplorerRaid;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.w3c.dom.Attr;

public class Explorer implements IExplorerRaid {

    private final Logger logger = LogManager.getLogger();
    private Decision last_action = Decision.FLY;


    @Override
    public void initialize(String s) {
        logger.info("** Initializing the Exploration Command Center");
        JSONObject info = new JSONObject(new JSONTokener(new StringReader(s)));
        logger.info("** Initialization info:\n {}",info.toString(2));
        String direction = info.getString("heading");
        Integer batteryLevel = info.getInt("budget");
        logger.info("The drone is facing {}", direction);
        logger.info("Battery level is {}", batteryLevel);
    }

    @Override
    public String takeDecision() {
        JSONObject decision = new JSONObject();
        Decision curr_action = Decision.FLY;
        if (last_action.equals(Decision.SCAN)) {
            last_action = Decision.STOP;

        } else {
            last_action = Decision.FLY;
            last_action = Decision.SCAN;
        }

        decision.put("action",last_action.getName());

        logger.info("** Decision: {}",decision.toString());
        return decision.toString();
    }

    @Override
    public void acknowledgeResults(String s) {
        JSONObject response = new JSONObject(new JSONTokener(new StringReader(s)));
        System.out.println(response);
        AttributeRecord attributeRecord = new AttributeRecord();
        attributeRecord.updateAttributes(response.getInt("budget"),-1,-1);
        logger.info("** Response received:\n"+response.toString(2));
        Integer cost = response.getInt("cost");
        logger.info("The cost of the action was {}", cost);
        String status = response.getString("status");
        logger.info("The status of the drone is {}", status);
        JSONObject extraInfo = response.getJSONObject("extras");
        logger.info("Additional information received: {}", extraInfo);
    }

    @Override
    public String deliverFinalReport() {


        return "no creek found";
    }

}
