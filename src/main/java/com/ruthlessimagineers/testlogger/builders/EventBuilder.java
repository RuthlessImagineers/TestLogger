package com.ruthlessimagineers.testlogger.builders;

import com.ruthlessimagineers.testlogger.entities.Event;
import com.ruthlessimagineers.testlogger.utils.Status;


public class EventBuilder {

    private Event event;

    public EventBuilder() {
        event = new Event();
    }

    public EventBuilder withName(String name) {
        event.setName(name);
        return this;
    }

    public EventBuilder withID(String id) {
        event.setId(id);
        return this;
    }

    public EventBuilder withMessage(String message) {
        event.setMessage(message);
        return this;
    }

    public EventBuilder withStatus(Status status) {
        event.setStatus(status);
        return this;
    }

    public Event build() {
        return event;
    }
}
