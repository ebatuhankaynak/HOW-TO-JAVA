package com.mocha.Admin.JsonListenerCapsule;

public class JsonRequest {
    private RequestTypes type;
    private Object object;

    public JsonRequest(RequestTypes type, Object object) {
        this.type = type;
        this.object = object;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public RequestTypes getType() {
        return type;
    }

    public void setType(RequestTypes type) {
        this.type = type;
    }
}
