package com.mocha.client.controllers;

import com.mocha.client.Core;
import com.mocha.client.JsonListenerCapsule.JsonListener;
import com.mocha.client.JsonListenerCapsule.RequestTypes;
import com.mocha.client.Transition;
import com.mocha.client.models.Questions.CompiledQuestion;
import com.mocha.client.models.requests.QuestionRequest;
import com.mocha.client.models.requests.QuestionResultRequest;
import com.mocha.client.models.results.QuestionResults;
import com.mocha.client.models.User;
import com.mocha.client.models.Questions.CompiledQuestionContainer;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Topic Menu Controller. Topic Menu is the menu that shows after clicking the "Practice!" button
 * in the Main Menu.
 * Created by E.Batuhan Kaynak on 8.4.2016.
 */

public class TopicMenuController extends Controller implements Initializable{

    @FXML Label dataTypesMastery;
    @FXML ArrayList<Label> labelList;
    private CompiledQuestionContainer questions;
    private CompiledQuestion questionToShow;

    private final String[] topics = {"RECURSION", "STRING", "CLASS"};

    public TopicMenuController()
    {
        Core.JsonListenerManager.addJsonListener(RequestTypes.QUESTION_RESULT, new JsonListener<QuestionResultRequest>() {
            @Override
            public void run(QuestionResultRequest req) {
                QuestionResults res = req.getResult();
                if (res == QuestionResults.SUCCESS) {
                    questions = req.getQuestions();
                    Core.Storage.setQuestionToShow(questions.getQuestions().get(0));
                    Core.Storage.setQuestionContainer(questions);
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            goToScene("CodingMenu");
                        }
                    });
                } else if (res == QuestionResults.FAILURE) {
                }
            }
        });
    }

    @FXML
    public void onRecursionButtonClick(MouseEvent mouseEvent) {
        requestQuestions("RECURSION", "1");
    }

    @FXML
    public void onMethodsButtonClick(MouseEvent mouseEvent) {
        requestQuestions("METHOD", "1");
    }

    public void requestQuestions(String topicType, String level)
    {
        Core.SocketManager.sendMessageObject(RequestTypes.QUESTION, new QuestionRequest(topicType, level));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        User user = Core.Storage.getUser();
        for (int i = 0; i < labelList.size(); i++) {
            String star = "*";
            System.out.println(user.getLevel(topics[i]));
            for (int j = 0; j < user.getLevel(topics[i]); j++) {
                star = star + "*";
            }
            labelList.get(i).setText(star);
        }
    }
}
