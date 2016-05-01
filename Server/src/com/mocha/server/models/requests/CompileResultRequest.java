package com.mocha.server.models.requests;

import com.mocha.server.models.User;
import com.mocha.server.models.results.CompileResult;

/**
 * Created by Hüseyin on 4/23/2016.
 */
public class CompileResultRequest {

    private CompileResult result;
    private User user;
    private boolean [] compilerResults;
    private String [] errString;
    public CompileResultRequest(CompileResult result, boolean[] compilerResults, String[] errString  ) {
        this.result = result;
        this.compilerResults = compilerResults;
        this.errString = errString;
    }

    public CompileResult getResult() {
        return result;
    }

    public void setResult(CompileResult result) {
        this.result = result;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean[] getCompilerResults() {
        return compilerResults;
    }

    public void setCompilerResults(boolean[] compilerResults) {
        this.compilerResults = compilerResults;
    }

    public String[] getErrString() {
        return errString;
    }

    public void setErrString(String[] errString) {
        this.errString = errString;
    }
}
