package com.mocha.client;

import com.mocha.client.models.Questions.Question;
import com.mocha.client.models.User;
import com.mocha.client.models.requests.CompileResultRequest;

/**
 * Created by E.Batuhan Kaynak on 23.4.2016.
 */
public class Storage {
    private User user;
    private Question questionToShow;
    private CompileResultRequest compileResultRequest;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Question getQuestionToShow() {
        return questionToShow;
    }

    public void setQuestionToShow(Question questionToShow) {
        this.questionToShow = questionToShow;
    }

    public CompileResultRequest getCompileResultRequest() {
        return compileResultRequest;
    }

    public void setCompileResultRequest(CompileResultRequest compileResultRequest) {
        this.compileResultRequest = compileResultRequest;
    }
}
