package com.mocha.client.models.requests;

import com.mocha.client.models.User;
import com.mocha.client.models.results.LoginResults;

public class LoginResultRequest {

    private LoginResults result;
    private User user;

    public LoginResultRequest(LoginResults result, User user) {
        this.result = result;
        this.user = user;
    }

    public LoginResults getResult() {
        return result;
    }

    public void setResult(LoginResults result) {
        this.result = result;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
