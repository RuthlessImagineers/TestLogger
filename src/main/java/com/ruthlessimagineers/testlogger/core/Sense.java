package com.ruthlessimagineers.testlogger.core;

import com.ruthlessimagineers.testlogger.builders.ScribbleRequestBuilder;
import com.ruthlessimagineers.testlogger.entities.*;
import com.ruthlessimagineers.testlogger.utils.RequestType;
import gherkin.deps.com.google.gson.JsonObject;
import org.apache.http.HttpEntity;
import org.apache.http.nio.entity.NStringEntity;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class Sense {

    private Scratch scratch;
    private List<ScribbleRequest> eventRequests,personaRequests,notesRequests;

    public Sense(Scratch scratch) {
        this.scratch = scratch;
        eventRequests = new ArrayList<>();
        personaRequests = new ArrayList<>();
        notesRequests = new ArrayList<>();
    }

    public void findSense() {
        buildEventRequests();
        buildPersonaRequests();
        buildNotesRequests();
    }

    public List<ScribbleRequest> getEventRequests() {
        return eventRequests;
    }

    public List<ScribbleRequest> getPersonaRequests() {
        return personaRequests;
    }

    public List<ScribbleRequest> getNotesRequests() {
        return notesRequests;
    }

    private void buildEventRequests() {
        List<Event> events = scratch.getEvents();
        events.forEach(event -> {
            JsonObject eventObject = getEventsObject(event);
            String header = "scribble/scenario/"+event.getId();
            try {
                ScribbleRequest eventConsumer = new ScribbleRequestBuilder()
                        .withRequestType(RequestType.POST)
                        .withHeader(header)
                        .withHttpEntity(getHttpEntity(eventObject))
                        .build();
                eventRequests.add(eventConsumer);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        });
    }

    private void buildPersonaRequests() {
        List<Persona> personas = scratch.getPersonas();
        personas.forEach(persona -> {
            JsonObject personaObject = getPersonasObject(persona);
            String header = "scribble/scenario/"+persona.getId();
            try {
                ScribbleRequest personaConsumer = new ScribbleRequestBuilder()
                        .withRequestType(RequestType.POST)
                        .withHeader(header)
                        .withHttpEntity(getHttpEntity(personaObject))
                        .build();
                personaRequests.add(personaConsumer);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        });
    }

    private void buildNotesRequests() {
        List<Note> notes = scratch.getNotes();
        notes.forEach(note -> {
            JsonObject noteObject = getNotesObject(note);
            String header = "scribble/scenario/"+note.getId();
            try {
                ScribbleRequest noteConsumer = new ScribbleRequestBuilder()
                        .withRequestType(RequestType.POST)
                        .withHeader(header)
                        .withHttpEntity(getHttpEntity(noteObject))
                        .build();
                notesRequests.add(noteConsumer);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        });
    }

    private JsonObject getEventsObject(Event event) {
        JsonObject eventsObject = new JsonObject();
        eventsObject.addProperty("id",event.getId());
        eventsObject.addProperty("event",event.getName());
        eventsObject.addProperty("message",event.getMessage());
        eventsObject.addProperty("status",event.getStatus().getStatus());
        return eventsObject;
    }

    private JsonObject getPersonasObject(Persona persona) {
        JsonObject eventsObject = new JsonObject();
        eventsObject.addProperty("id",persona.getId());
        eventsObject.addProperty("persona",persona.getName());
        eventsObject.addProperty("message",persona.getMessage());
        eventsObject.addProperty("status",persona.getStatus().getStatus());
        return eventsObject;
    }

    private JsonObject getNotesObject(Note note) {
        JsonObject notesObject = new JsonObject();
        notesObject.addProperty("id",note.getId());
        notesObject.addProperty("note",note.getMessage());
        return notesObject;
    }

    private HttpEntity getHttpEntity(JsonObject jsonObject) throws UnsupportedEncodingException {
        return new NStringEntity(jsonObject.toString());
    }
}
