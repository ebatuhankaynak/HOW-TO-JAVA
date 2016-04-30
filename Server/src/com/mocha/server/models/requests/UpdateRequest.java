package com.mocha.server.models.requests;

import com.mocha.server.models.User;

/**
 * Created by Ziya on 30.04.2016.
 */
public class UpdateRequest
{
    // Instance Variables
    private User user;

    // Constructor
    public UpdateRequest( User user)
    {
        this.user = user;
    }

    public UpdateRequest() {}

    public String toCheckUsernameQuery(){
        return "{ username: '"+ user.getUsername() + "' }";
    }

    public User getUser()
    {
        return user;
    }

    public void setUser( User user )
    {
        this.user = user;
    }
}
