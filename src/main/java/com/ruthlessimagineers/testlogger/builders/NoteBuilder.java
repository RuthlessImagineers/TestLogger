package com.ruthlessimagineers.testlogger.builders;

import com.ruthlessimagineers.testlogger.entities.Note;

/**
 * Created by krishnanand on 22/01/17.
 */
public class NoteBuilder {

    private Note note;
    public NoteBuilder() {
        note = new Note();
    }

    public NoteBuilder withID(String id) {
        note.setId(id);
        return this;
    }

    public NoteBuilder withMessage(String message) {
        note.setMessage(message);
        return this;
    }

    public Note build() {
        return note;
    }
}
