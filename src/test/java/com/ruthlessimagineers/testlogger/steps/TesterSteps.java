package com.ruthlessimagineers.testlogger.steps;

import com.ruthlessimagineers.testlogger.Scribble;
import com.ruthlessimagineers.testlogger.Scribbler;
import com.ruthlessimagineers.testlogger.utils.Status;
import cucumber.api.java8.En;

public class TesterSteps implements En {
    private Scribble scribble;
    public TesterSteps() {
        Given("^I am a tester$", () -> {
            scribble = Scribbler.getPaper();
            scribble.persona("Tester", "I am a tester",Status.FAIL);
        });
        Then("^I test$", () -> {
            scribble = Scribbler.getPaper();
            scribble.persona("Developer","I am a developer", Status.PASS);
        });
    }
}
