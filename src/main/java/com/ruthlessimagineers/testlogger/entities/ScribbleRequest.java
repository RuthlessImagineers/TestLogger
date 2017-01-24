package com.ruthlessimagineers.testlogger.entities;

import com.ruthlessimagineers.testlogger.utils.RequestType;
import org.apache.http.HttpEntity;


public class ScribbleRequest {

    private String header;
    private RequestType requestType;
    private HttpEntity httpEntity;

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public RequestType getRequestType() {
        return requestType;
    }

    public void setRequestType(RequestType requestType) {
        this.requestType = requestType;
    }

    public HttpEntity getHttpEntity() {
        return httpEntity;
    }

    public void setHttpEntity(HttpEntity httpEntity) {
        this.httpEntity = httpEntity;
    }
}
