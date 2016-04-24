package com.mocha.client.controllers;

import com.mocha.client.Core;
import com.mocha.client.JsonListenerCapsule.JsonListener;
import com.mocha.client.JsonListenerCapsule.RequestTypes;
import com.mocha.client.Transition;
import com.mocha.client.models.requests.QuestionRequest;
import com.mocha.client.models.requests.QuestionResultRequest;
import com.mocha.client.models.results.QuestionResults;
import com.mocha.client.models.Questions.Question;
import com.mocha.client.models.Questions.QuestionContainer;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

/**
 * Topic Menu Controller. Topic Menu is the menu that shows after clicking the "Practice!" button
 * in the Main Menu.
 * Created by E.Batuhan Kaynak on 8.4.2016.
 */

public class TopicMenuController extends Controller {

    private QuestionContainer questions;
    private Question questionToShow;

    public TopicMenuController()
    {
        Core.JsonListenerManager.addJsonListener(RequestTypes.QUESTION_RESULT, new JsonListener<QuestionResultRequest>() {
            @Override
            public void run(QuestionResultRequest req) {
                QuestionResults res = req.getResult();
                System.out.println(res);
                if (res == QuestionResults.SUCCESS) {
                    questions = req.getQuestions();
                    Core.Storage.setQuestionToShow(questions.getQuestions().get(0));
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            goToScene("CodingMenu");
                        }
                    });
                } else if (res == QuestionResults.FAILURE) {
                    System.out.println("Rip questions");
                }
            }
        });
    }

    @FXML
    public void onDataTypesButtonClick(MouseEvent mouseEvent) {
        requestQuestions("DATA_TYPES", "1");
    }

    @FXML
    public void onMethodsButtonClick(MouseEvent mouseEvent) {
        requestQuestions("METHOD", "1");
        //goToScene("CodingMenu");
    }

    public void requestQuestions(String topicType, String level)
    {
        Core.SocketManager.sendMessageObject(RequestTypes.QUESTION, new QuestionRequest(topicType, level));
    }

    public void goToCodingMenu(Question questionToShow) {
        goToScene("CodingMenu", questionToShow);
    }

    private void goToScene(String codingMenu, Question questionToShow) {
        new Transition(getPrevStage(), codingMenu, questionToShow).changeScene();
    }
}
