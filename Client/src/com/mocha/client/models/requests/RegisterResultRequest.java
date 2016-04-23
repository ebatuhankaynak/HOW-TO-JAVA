package com.mocha.client.models.requests;

import com.mocha.server.models.results.RegisterResults;

public class RegisterResultRequest {

    private RegisterResults result;

    public RegisterResultRequest(RegisterResults result) {
        this.result = result;
    }

    public RegisterResults getResult() {
        return result;
    }

    public void setResult(RegisterResults result) {
        this.result = result;
    }
}
