package com.mocha.server.repository;

import com.mocha.server.models.Admin;
import com.mocha.server.models.requests.LoginRequest;
import com.mocha.server.models.requests.RegisterRequest;
import com.mocha.server.models.results.RegisterResults;
import org.jongo.MongoCollection;

/**
 * Created by E.Batuhan Kaynak on 29.4.2016.
 */
public class AdminRepository {

    private MongoCollection admins;

    public AdminRepository (MongoCollection admin) {
        this.admins = admins;
    }

    public Admin authenticate(LoginRequest loginRequest){
        Admin admin = admins.findOne(loginRequest.toAuthenticateQuery()).as(Admin.class);
        return admin ;
    }

    public RegisterResults register(RegisterRequest registerRequest){
        RegisterResults res;

        if (admins.findOne(registerRequest.toCheckUsernameQuery()).as(Admin.class) != null){
            res = RegisterResults.USERNAME_EXISTS;
        }else{
            Admin admin = new Admin();
            admin.setUsername(registerRequest.getUsername());
            admin.setPassword(registerRequest.getPassword());
            admins.save(admin);
            res = RegisterResults.SUCCESS;
        }
        return res;
    }
}
