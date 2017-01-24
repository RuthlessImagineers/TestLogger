package com.ruthlessimagineers.testlogger.exceptions;

/**
 * Created by krishnanand on 22/01/17.
 */
public class NoScenarioDefinedException extends Exception {

    public NoScenarioDefinedException() {
        super("Please store scenario instance initialized by cucumber in @Before hook, as a local variable");
    }
}
