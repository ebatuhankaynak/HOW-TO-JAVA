package com.mocha.client.models.requests;

import com.mocha.client.models.results.LoginResults;

public class LoginResultRequest {

    private LoginResults result;

    public LoginResultRequest(LoginResults result) {
        this.result = result;
    }

    public LoginResults getResult() {
        return result;
    }

    public void setResult(LoginResults result) {
        this.result = result;
    }
}
