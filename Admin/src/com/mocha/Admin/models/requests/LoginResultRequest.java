package com.mocha.Admin.models.requests;

import com.mocha.Admin.models.Admin;
import com.mocha.Admin.models.results.LoginResults;

/**
 * Created by E.Batuhan Kaynak on 28.4.2016.
 */

public class LoginResultRequest {

    private LoginResults result;
    private Admin admin;

    public LoginResultRequest(LoginResults result, Admin admin) {
        this.result = result;
        this.admin = admin;
    }

    public LoginResults getResult() {
        return result;
    }

    public void setResult(LoginResults result) {
        this.result = result;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
}
