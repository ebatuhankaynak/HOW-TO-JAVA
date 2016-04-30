package com.mocha.server.repository;

import com.mocha.server.models.User;
import com.mocha.server.models.requests.LoginRequest;
import com.mocha.server.models.requests.RegisterRequest;
import com.mocha.server.models.results.RegisterResults;
import org.jongo.MongoCollection;

public class UsersRepository {

    private MongoCollection users;

    public UsersRepository(MongoCollection users) {
        this.users = users;
    }

    public User authenticate(LoginRequest loginRequest){
        User user = users.findOne(loginRequest.toAuthenticateQuery()).as(User.class);
        return user ;
    }

    public void update( User user)
    {
        users.save( user);
    }

    public RegisterResults register(RegisterRequest registerRequest){
        RegisterResults res;

        if (users.findOne(registerRequest.toCheckUsernameQuery()).as(User.class) != null){
            res = RegisterResults.USERNAME_EXISTS;
        }else{
            User user = new User();
            user.setUsername(registerRequest.getUsername());
            user.setPassword(registerRequest.getPassword());
            users.save(user);
            res = RegisterResults.SUCCESS;
        }

        return res;
    }
}
