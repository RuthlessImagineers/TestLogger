package com.ruthlessimagineers.testlogger;


import com.ruthlessimagineers.testlogger.utils.Status;
import cucumber.api.Scenario;

public interface Scribble {

    void scribble(String message);

    void event(String name, Status status);

    void event(String name, String message, Status status);

    void persona(String name, Status status);

    void persona(String name, String message, Status status);

    void shred();

}
