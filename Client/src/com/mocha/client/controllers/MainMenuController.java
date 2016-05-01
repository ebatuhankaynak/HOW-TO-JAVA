package com.mocha.client.controllers;

import com.mocha.client.Core;
import com.mocha.client.JsonListenerCapsule.JsonListener;
import com.mocha.client.JsonListenerCapsule.RequestTypes;
import com.mocha.client.models.requests.QuestionRequest;
import com.mocha.client.models.requests.QuestionResultRequest;
import com.mocha.client.models.requests.UpdateRequest;
import com.mocha.client.models.results.QuestionResults;
import com.mocha.client.models.Questions.CompiledQuestionContainer;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.util.Optional;

/**
 * Created by E.Batuhan Kaynak on 28.3.2016.
 */

public class MainMenuController extends Controller {

    private CompiledQuestionContainer questions;

    public MainMenuController(){
        Core.JsonListenerManager.addJsonListener(RequestTypes.QUESTION_RESULT, new JsonListener<QuestionResultRequest>() {
            @Override
            public void run(QuestionResultRequest req) {
                QuestionResults res = req.getResult();
                System.out.println(res);
                if (res == QuestionResults.SUCCESS) {
                    questions = req.getQuestions();
                    Core.Storage.setQuestionToShow(questions.getQuestions().get(0));
                    //questions.getQuestions().remove(0);
                    Core.Storage.setQuestionContainer(questions);
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            goToScene("DiagnosticTest");
                        }
                    });
                } else if (res == QuestionResults.FAILURE) {
                    System.out.println("Rip questions");
                }
            }
        });
    }
    @FXML
    private void onPracticeButtonClick(MouseEvent mouseEvent){
        goToScene("TopicMenu");
    }

    @FXML
    private void onProfileButtonButtonClick(MouseEvent mouseEvent){
        goToScene("Profile");
    }

    @FXML
    private void onDiagnosticTestButtonClick(MouseEvent mouseEvent){
        Core.SocketManager.sendMessageObject(RequestTypes.QUESTION, new QuestionRequest("RANDOM", "-1"));
    }

    @FXML
    private void onShopButtonClick(MouseEvent mouseEvent){
        goToScene("Shop");
    }

    @FXML
    private void onOptionsButtonClick(MouseEvent mouseEvent){
        goToScene("Options");
    }

    @FXML
    private void onExitButtonClick(MouseEvent mouseEvent) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Exit Program?");
        alert.setHeaderText("Are you sure you want to quit How To Java?");

        ButtonType yesButton =  new ButtonType("Yes");
        ButtonType noButton =  new ButtonType("No");
        alert.getButtonTypes().setAll(yesButton, noButton);

        alert.setGraphic(new ImageView(new Image(String.valueOf(getClass().getResource("../resources/images/java.png")))));

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == yesButton) {
            Core.SocketManager.sendMessageObject(RequestTypes.UPDATE, new UpdateRequest(Core.Storage.getUser()));
            System.exit(0);
        }
    }
}
