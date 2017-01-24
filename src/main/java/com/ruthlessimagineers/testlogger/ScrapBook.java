package com.ruthlessimagineers.testlogger;

import com.ruthlessimagineers.testlogger.builders.EventBuilder;
import com.ruthlessimagineers.testlogger.builders.NoteBuilder;
import com.ruthlessimagineers.testlogger.builders.PersonaBuilder;
import com.ruthlessimagineers.testlogger.builders.ScratchBuilder;
import com.ruthlessimagineers.testlogger.core.ScenarioDetails;
import com.ruthlessimagineers.testlogger.core.Sense;
import com.ruthlessimagineers.testlogger.entities.*;
import com.ruthlessimagineers.testlogger.utils.Status;
import cucumber.api.Scenario;
import gherkin.deps.com.google.gson.JsonObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public abstract class ScrapBook {

    private static Object o;
    private static RestClient restClient;
    private Scenario scenario;
    private static ScenarioDetails scenarioDetails;
    private List<Event> events;
    private List<Persona> personas;
    private List<Note> notes;

    protected ScrapBook(Scenario scenario)  {
        this.scenario = scenario;
        events = new ArrayList<>();
        personas = new ArrayList<>();
        notes = new ArrayList<>();
        setup();
    }

    private void setup() {
        restClient = RestClient.builder(new HttpHost("localhost",9200,"HTTP")).build();
        scenarioDetails = getScenarioDetails();
    }

    protected void scribbleEvent(String name, Status status) {
        Event event = new EventBuilder()
                .withID(scenarioDetails.getScenarioName())
                .withName(name)
                .withStatus(status)
                .build();
        storeEvent(event);
    }

    protected void scribbleEvent(String name,String message, Status status) {
        Event event = new EventBuilder()
                .withID(scenarioDetails.getScenarioName())
                .withName(name)
                .withMessage(message)
                .withStatus(status)
                .build();
        storeEvent(event);
    }

    protected void scribblePersona(String name, Status status) {
       Persona persona = new PersonaBuilder()
               .withID(scenarioDetails.getScenarioName())
               .withName(name)
               .withStatus(status)
               .build();
        storePersona(persona);
    }

    protected void scribblePersona(String name, String message, Status status) {
        Persona persona = new PersonaBuilder()
                .withID(scenarioDetails.getScenarioName())
                .withMessage(message)
                .withName(name)
                .withStatus(status)
                .build();
        storePersona(persona);
    }

    protected void scribble(String message) {
        Note note = new NoteBuilder()
                .withID(scenarioDetails.getScenarioName())
                .withMessage(message)
                .build();
        storeNote(note);
    }

    protected void trash() {
        Scratch scratch = getScratch();
        Sense sense = new Sense(scratch);
        sense.findSense();
        request(sense.getEventRequests());
        request(sense.getNotesRequests());
        request(sense.getPersonaRequests());
    }

    private ScenarioDetails getScenarioDetails() {
        return new ScenarioDetails(scenario.getId());
    }

    private void storeEvent(Event event) {
        events.add(event);
    }

    private void storePersona(Persona persona) {
        personas.add(persona);
    }

    private void storeNote(Note note) {
        notes.add(note);
    }

    private void request(List<ScribbleRequest> requests) {
        requests.forEach(request -> {
            try {
                Response response = restClient.performRequest(request.getRequestType().name(),request.getHeader(), Collections.emptyMap(),request.getHttpEntity());
                System.out.println(response.getEntity());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private Scratch getScratch() {
        Scratch scratch = new ScratchBuilder()
                .withEvents(events)
                .withNotes(notes)
                .withPersonas(personas)
                .withScenarioDetails(scenarioDetails)
                .build();
        return scratch;
    }
}
