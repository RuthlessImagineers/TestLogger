package com.ruthlessimagineers.testlogger.core;

import java.util.Arrays;

/**
 * Created by krishnanand on 19/01/17.
 */
public class ScenarioDetails {

    private String scenarioID;
    private String scenarioName;
    private String featureName;

    public ScenarioDetails(String scenarioID) {
        this.scenarioID = scenarioID;
        formatScenarioID();
    }

    public String getScenarioName() {
        return scenarioName;
    }

    public String getFeatureName() {
        return featureName;
    }

    private void formatScenarioID() {
        String[] scenarioDetails = scenarioID.split(";");
        featureName = scenarioDetails[0];
        if(scenarioDetails.length>2) {
            StringBuilder strBldr = new StringBuilder();
            Arrays.stream(scenarioDetails).forEach(str->strBldr.append(str));
            scenarioName = strBldr.toString().replace(featureName,"");
        } else {
            scenarioName = scenarioDetails[1];
        }
    }
}
