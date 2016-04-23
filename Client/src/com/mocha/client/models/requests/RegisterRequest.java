package com.mocha.client.models.requests;

public class RegisterRequest {
    private String username;
    private String password;

    public RegisterRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public RegisterRequest(){

    }

    public String toCheckUsernameQuery(){
        return "{ username: '"+username + "' }";
    }
}
