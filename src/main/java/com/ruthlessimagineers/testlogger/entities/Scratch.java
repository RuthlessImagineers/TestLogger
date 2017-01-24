package com.ruthlessimagineers.testlogger.entities;

import com.ruthlessimagineers.testlogger.core.ScenarioDetails;
import cucumber.api.Scenario;

import java.util.List;

/**
 * Created by krishnanand on 22/01/17.
 */
public class Scratch {

    private List<Event> events;
    private List<Persona> personas;
    private List<Note> notes;
    private ScenarioDetails scenarioDetails;

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    public ScenarioDetails getScenarioDetails() {
        return scenarioDetails;
    }

    public void setScenarioDetails(ScenarioDetails scenarioDetails) {
        this.scenarioDetails = scenarioDetails;
    }
}
