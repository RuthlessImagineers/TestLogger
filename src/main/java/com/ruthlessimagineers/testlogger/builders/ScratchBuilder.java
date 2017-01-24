package com.ruthlessimagineers.testlogger.builders;

import com.ruthlessimagineers.testlogger.core.ScenarioDetails;
import com.ruthlessimagineers.testlogger.entities.Event;
import com.ruthlessimagineers.testlogger.entities.Note;
import com.ruthlessimagineers.testlogger.entities.Persona;
import com.ruthlessimagineers.testlogger.entities.Scratch;

import java.util.List;

/**
 * Created by krishnanand on 22/01/17.
 */
public class ScratchBuilder {

    private Scratch scratch;
    public ScratchBuilder() {
        scratch = new Scratch();
    }


    public ScratchBuilder withEvents(List<Event> events) {
        scratch.setEvents(events);
        return this;
    }

    public ScratchBuilder withPersonas(List<Persona> personas) {
        scratch.setPersonas(personas);
        return this;
    }

    public ScratchBuilder withNotes(List<Note> notes) {
        scratch.setNotes(notes);
        return this;
    }

    public ScratchBuilder withScenarioDetails(ScenarioDetails scenarioDetails) {
        scratch.setScenarioDetails(scenarioDetails);
        return this;
    }

    public Scratch build() {
        return scratch;
    }
}
