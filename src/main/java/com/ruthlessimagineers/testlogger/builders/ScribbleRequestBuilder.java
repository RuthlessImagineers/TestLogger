package com.ruthlessimagineers.testlogger.builders;

import com.ruthlessimagineers.testlogger.entities.ScribbleRequest;
import com.ruthlessimagineers.testlogger.utils.RequestType;
import org.apache.http.HttpEntity;

public class ScribbleRequestBuilder {

    private ScribbleRequest scribbleRequest;

    public ScribbleRequestBuilder() {
        scribbleRequest = new ScribbleRequest();
    }

    public ScribbleRequestBuilder withHeader(String header) {
        scribbleRequest.setHeader(header);
        return this;
    }

    public ScribbleRequestBuilder withRequestType(RequestType requestType) {
        scribbleRequest.setRequestType(requestType);
        return this;
    }

    public ScribbleRequestBuilder withHttpEntity(HttpEntity httpEntity) {
        scribbleRequest.setHttpEntity(httpEntity);
        return this;
    }

    public ScribbleRequest build() {
        return scribbleRequest;
    }
}
