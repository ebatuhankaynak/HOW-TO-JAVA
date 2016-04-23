package com.mocha.server.listeners;

import com.mocha.server.Core;
import com.mocha.server.JsonListenerCapsule.JsonListener;
import com.mocha.server.JsonListenerCapsule.RequestTypes;
import com.mocha.server.models.User;
import com.mocha.server.models.requests.LoginRequest;
import com.mocha.server.models.requests.LoginResultRequest;
import com.mocha.server.models.results.LoginResults;
/**
 *   Hüseyin Orkun Elmas
 *
 * */
public class LoginListener extends JsonListener<LoginRequest> {

    @Override
    public void run(LoginRequest req) {
        LoginResults res;
        User user = Core.Repository.getUsers().authenticate(req);
        if (user != null)
        {
            res = LoginResults.SUCCESS;
        }
        else
        {
            res = LoginResults.WRONG;
        }

        Core.ServerManager.sendMessageObject(getClientUID(), RequestTypes.LOGIN_RESULT, new LoginResultRequest(res, user));
        System.out.println("sent " + res);
    }
}
