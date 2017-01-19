package com.ruthlessimagineers.testlogger.steps;

import com.ruthlessimagineers.testlogger.TestLogger;
import cucumber.api.PendingException;
import cucumber.api.java8.En;

/**
 * Created by krishnanand on 19/01/17.
 */
public class TesterSteps implements En {
    private TestLogger testLogger;
    public TesterSteps() {
        testLogger = TestLogger.getLogger(this);
        Given("^I am a tester$", () -> {
          //  System.out.println("Tester");
            testLogger.log("In Step I am a tester");
        });
        Then("^I test$", () -> {
         testLogger.log("In step I test");
        });
    }
}
