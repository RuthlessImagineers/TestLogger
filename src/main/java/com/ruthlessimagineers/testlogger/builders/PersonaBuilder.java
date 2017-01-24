package com.ruthlessimagineers.testlogger.builders;


import com.ruthlessimagineers.testlogger.entities.Persona;
import com.ruthlessimagineers.testlogger.utils.Status;

public class PersonaBuilder {

    private Persona persona;
    public PersonaBuilder() {
        persona = new Persona();
    }

    public PersonaBuilder withName(String name) {
        persona.setName(name);
        return this;
    }

    public PersonaBuilder withID(String id) {
        persona.setId(id);
        return this;
    }

    public PersonaBuilder withMessage(String message) {
        persona.setMessage(message);
        return this;
    }

    public PersonaBuilder withStatus(Status status) {
        persona.setStatus(status);
        return this;
    }

    public Persona build() {
        return persona;
    }
}
