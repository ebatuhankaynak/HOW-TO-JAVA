package com.mocha.client;

import com.mocha.client.models.Questions.CompiledQuestion;
import com.mocha.client.models.Questions.Question;
import com.mocha.client.models.User;
import com.mocha.client.models.requests.CompileResultRequest;
import javafx.scene.Scene;

/**
 * Created by E.Batuhan Kaynak on 23.4.2016.
 */
public class Storage {
    private User user;
    private Question questionToShow;
    private CompileResultRequest compileResultRequest;
    private Scene scene;
    private String selectedTheme;
    private String codeToShow;

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

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public String getSelectedTheme() {
        return selectedTheme;
    }

    public void setSelectedTheme(String selectedTheme) {
        this.selectedTheme = selectedTheme;
    }

    public String getCodeToShow() {
        return codeToShow;
    }

    public void setCodeToShow(String codeToShow) {
        this.codeToShow = codeToShow;
    }
}
