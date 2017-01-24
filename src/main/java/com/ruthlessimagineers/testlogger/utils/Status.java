package com.ruthlessimagineers.testlogger.utils;

/**
 * Created by krishnanand on 22/01/17.
 */
public enum Status {
    PASS("passed"),
    FAIL("failed"),
    INPROGRESS("inprogress");

    private String status;
    Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
