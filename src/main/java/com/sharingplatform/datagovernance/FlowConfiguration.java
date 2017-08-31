package com.sharingplatform.datagovernance;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.json.JSONArray;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by AMC on 2017/8/16.
 */
public class FlowConfiguration {

    private ArrayNode flowConfig;

    public FlowConfiguration() {
        try {
            init();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void init() throws IOException {
        String jsonConfig = "[" +
                "{\"stepKey\": \"form-filling\", \"flowButtons\": [{\"buttonName\": \"Submit\", \"nextStep\": \"pre-check\"},{\"buttonName\": \"Close\", \"nextStep\": \"\"}]}," +
                "{\"stepKey\": \"pre-check\", \"flowButtons\": [{\"buttonName\": \"Submit\", \"nextStep\": \"supervisor-approval\"},{\"buttonName\": \"Reject\", \"nextStep\": \"form-filling\"}]}," +
                "{\"stepKey\": \"supervisor-approval\", \"flowButtons\": [{\"buttonName\": \"Submit\", \"nextStep\": \"manager-approval\"},{\"buttonName\": \"Reject\", \"nextStep\": \"form-filling\"}]}," +
                "{\"stepKey\": \"manager-approval\", \"flowButtons\": [{\"buttonName\": \"Submit\", \"nextStep\": \"data-lake-architect\"},{\"buttonName\": \"Reject\", \"nextStep\": \"form-filling\"}]}," +
                "{\"stepKey\": \"data-lake-architect\", \"flowButtons\": [{\"buttonName\": \"Submit\", \"nextStep\": \"\"}]}" +
                "]";
        ObjectMapper mapper = new ObjectMapper();
        flowConfig = (ArrayNode)mapper.readTree(jsonConfig);
    }

    public String getNextStep(String stepKey, String buttonName) {
        String nextStepKey = "";
        for (JsonNode stepConfig : flowConfig) {
            String tempStepKey = stepConfig.get("stepKey").asText();
            if(stepKey.equals(tempStepKey)) {
                ArrayNode flowButtons = (ArrayNode)stepConfig.get("flowButtons");
                for (JsonNode buttonConfig : flowButtons) {
                    String tempButtonName = buttonConfig.get("buttonName").asText();
                    if(buttonName.equals(tempButtonName)) {
                        nextStepKey = buttonConfig.get("nextStep").asText();
                        return nextStepKey;
                    }
                }
            }
        }
        return nextStepKey;
    }

    public ArrayNode getFlowButtons(String stepKey) {
        for (JsonNode stepConfig : flowConfig) {
            String tempStepKey = stepConfig.get("stepKey").asText();
            if(stepKey.equals(tempStepKey)) {
                ArrayNode flowButtons = (ArrayNode)stepConfig.get("flowButtons");
                return flowButtons;
            }
        }
        return null;
    }

}
