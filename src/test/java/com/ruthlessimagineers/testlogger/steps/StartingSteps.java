package com.ruthlessimagineers.testlogger.steps;


import com.ruthlessimagineers.testlogger.Scribble;
import com.ruthlessimagineers.testlogger.Scribbler;
import com.ruthlessimagineers.testlogger.utils.Status;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;


public class StartingSteps {

    private Scenario scenario;

    @Before
    public void setup(Scenario scenario) {
        this.scenario = scenario;
        Scribble scribble = Scribbler.createPaper(scenario);
        scribble.event("Setup", Status.PASS);
    }

    @After
    public void tearDown() {
        Scribble scribble = Scribbler.getPaper();
        scribble.event("Teardown",Status.PASS);
        scribble.shred();
    }
}
