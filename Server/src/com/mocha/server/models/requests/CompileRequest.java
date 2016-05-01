package com.mocha.server.models.requests;

import com.mocha.server.models.Questions.CompiledQuestion;

public class CompileRequest
{
    //mght delete userneame variable
    private String codeToCompile;
    private String userName;
    private CompiledQuestion question;
    public CompileRequest (String codeToCompile, String userName, CompiledQuestion question)
    {
        this.codeToCompile = codeToCompile;
        this.userName = userName;
        this.question = question;
    }

    public CompileRequest ()
    {

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

    public void setQuestion(CompiledQuestion question) {
        this.question = question;
    }

    public CompiledQuestion getQuestion() {
        return question;
    }
}
