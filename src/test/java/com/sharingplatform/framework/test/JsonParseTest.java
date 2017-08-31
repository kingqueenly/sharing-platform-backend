package com.sharingplatform.framework.test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.sharingplatform.datagovernance.FlowConfiguration;
import org.json.JSONArray;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by AMC on 2017/8/16.
 */
public class JsonParseTest {

    @Test
    public void testGetNextStep() {
        FlowConfiguration flowConfiguration = new FlowConfiguration();
        String stepKey = "manager-approval";
        String buttonName = "Submit";
        String nextStep = flowConfiguration.getNextStep(stepKey, buttonName);
        System.out.println(nextStep);
    }

    @Test
    public void testJsonParse() throws IOException {
        String genreJson = "[" +
                "{\"stepKey\": \"form-filling\", \"flowButtons\": [{\"buttonName\": \"Submit\", \"nextStep\": \"supervisor-approval\"},{\"buttonName\": \"Close\", \"nextStep\": \"\"}]}," +
                "{\"stepKey\": \"supervisor-approval\", \"flowButtons\": [{\"buttonName\": \"Submit\", \"nextStep\": \"manager-approval\"},{\"buttonName\": \"Reject\", \"nextStep\": \"form-filling\"}]}," +
                "{\"stepKey\": \"manager-approval\", \"flowButtons\": [{\"buttonName\": \"Submit\", \"nextStep\": \"ad-application\"},{\"buttonName\": \"Reject\", \"nextStep\": \"form-filling\"}]}," +
                "{\"stepKey\": \"ad-application\", \"flowButtons\": [{\"buttonName\": \"Submit\", \"nextStep\": \"it-owner-grant-access\"}]}," +
                "{\"stepKey\": \"it-owner-grant-access\", \"flowButtons\": [{\"buttonName\": \"Submit\", \"nextStep\": \"\"}]}" +
                "]";
        ObjectMapper mapper = new ObjectMapper();
        ArrayNode flowConfig = (ArrayNode)mapper.readTree(genreJson);

        JsonNode stepConfig = flowConfig.get(4);

        String stepKey = stepConfig.get("stepKey").asText();
        System.out.println(stepKey);
        ArrayNode flowButtons = (ArrayNode)stepConfig.get("flowButtons");
        JsonNode btn1 = flowButtons.get(0);
        String buttonName = btn1.get("buttonName").asText();
        System.out.println(buttonName);
        String nextStep = btn1.get("nextStep").asText();
        System.out.println(nextStep);
    }

}
