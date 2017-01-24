package com.ruthlessimagineers.testlogger;


import com.ruthlessimagineers.testlogger.utils.Status;
import cucumber.api.Scenario;

public class Scribbler extends ScrapBook implements Scribble {

    private static Scribbler scribbler;

    Scribbler(Scenario scenario) {
        super(scenario);
    }

    public static Scribble createPaper(Scenario scenario) {
        scribbler = new Scribbler(scenario);
        return scribbler;
    }

    public static Scribble getPaper() {
        return scribbler;
    }

    @Override
    public void scribble(String message) {
        super.scribble(message);
    }

    @Override
    public void event(String message, Status status) {
        scribbleEvent(message,status);
    }

    @Override
    public void event(String name, String message, Status status) {
        scribbleEvent(name,message,status);
    }

    @Override
    public void persona(String message, Status status) {
        scribblePersona(message,status);
    }

    @Override
    public void persona(String name, String message, Status status) {
        scribblePersona(name,message,status);
    }

    @Override
    public void shred() {
        trash();
    }
}
