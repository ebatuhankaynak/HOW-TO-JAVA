package com.mocha.server.listeners;

import com.mocha.server.Core;
import com.mocha.server.JsonListenerCapsule.JsonListener;
import com.mocha.server.JsonListenerCapsule.RequestTypes;
import com.mocha.server.models.requests.RegisterRequest;
import com.mocha.server.models.requests.RegisterResultRequest;
import com.mocha.server.models.results.RegisterResults;

public class RegisterListener extends JsonListener<RegisterRequest> {
    @Override
    public void run(RegisterRequest req){
        RegisterResults res = Core.Repository.getUsers().register(req);
        Core.ServerManager.sendMessageObject(getClientUID(), RequestTypes.REGISTER_RESULT, new RegisterResultRequest(res));
    }

}
