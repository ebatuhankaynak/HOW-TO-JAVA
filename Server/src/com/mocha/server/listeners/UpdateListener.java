package com.mocha.server.listeners;

import com.mocha.server.Core;
import com.mocha.server.JsonListenerCapsule.JsonListener;
import com.mocha.server.models.requests.UpdateRequest;

/**
 * Created by Ziya on 30.04.2016.
 */
public class UpdateListener extends JsonListener<UpdateRequest> {
    @Override
    public void run( UpdateRequest request){
        Core.Repository.getUsers().update( request.getUser());
    }
}
