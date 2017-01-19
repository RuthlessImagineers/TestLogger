package com.ruthlessimagineers.testlogger.steps;


import com.ruthlessimagineers.testlogger.TestLogger;
import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import gherkin.formatter.model.Feature;


public class StartingSteps {

    private Scenario scenario;

    @Before
    public void setup(Scenario scenario) {
        this.scenario = scenario;
        TestLogger testLogger = new TestLogger(this);
       testLogger.log("Starting with scenario --" +scenario.getName());
    }

    @After
    public void tearDown() {
        TestLogger testLogger = new TestLogger(this);
        testLogger.log("Scenario is -- "+scenario.getStatus());
    }
}
