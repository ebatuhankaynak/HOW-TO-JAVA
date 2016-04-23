package com.mocha.server.models.requests;

public class CompileRequest
{
    private String codeToCompile;
    private String userName;
    public CompileRequest ()
    {

    }

    public CompileRequest (String codeToCompile)
    {
        this.codeToCompile = codeToCompile;
    }

    public void setCodeToCompile(String codeToCompile) {
        this.codeToCompile = codeToCompile;
    }

    public String getCodeToCompile() {
        return codeToCompile;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }
}
