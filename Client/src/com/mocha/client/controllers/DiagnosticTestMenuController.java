package com.mocha.client.controllers;

import com.mocha.client.Core;
import com.mocha.client.JsonListenerCapsule.JsonListener;
import com.mocha.client.JsonListenerCapsule.RequestTypes;
import com.mocha.client.models.Questions.CompiledQuestion;
import com.mocha.client.models.requests.CompileRequest;
import com.mocha.client.models.requests.CompileResultRequest;
import com.mocha.client.models.results.CompileResults;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

/**
 * Created by E.Batuhan Kaynak on 17.4.2016.
 */

public class DiagnosticTestMenuController extends Controller implements Initializable{

    @FXML TextArea codingArea;
    @FXML ProgressBar progressBar;
    @FXML Label questionLabel;

    private CompiledQuestion question;

    public DiagnosticTestMenuController(){
        question = Core.Storage.getQuestionToShow();

        Core.JsonListenerManager.addJsonListener(RequestTypes.COMPILE_RESULT, new JsonListener<CompileResultRequest>() {
            @Override
            public void run(CompileResultRequest req) {
                System.out.println("IN CODING MENU");
                CompileResults res = req.getResult();
                System.out.println(res);
                if (res == CompileResults.SUCCESS) {
                    Core.Storage.setCompileResultRequest(req);
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            goToScene("DiagnosticTest");
                        }
                    });
                } else if (res == CompileResults.FAILURE) {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            Alert alert = new Alert(Alert.AlertType.WARNING);
                            alert.setTitle("Compile Error!");
                            alert.setHeaderText("JAVAC HAS NO IDEA WHAT YOU ARE SAYING!");
                            ButtonType okButton =  new ButtonType("Try Again:/");
                            alert.getButtonTypes().setAll(okButton);

                            Optional<ButtonType> result = alert.showAndWait();
                            if (result.get() == okButton) {
                                progressBar.setVisible(false);
                                //goToScene("CodingTest");
                            }
                        }
                    });
                }
            }
        });
    }

    @FXML
    public void onNextQuestionButtonClick(){

    }

    public void sendCodeToServer()
    {
        String userName = Core.Storage.getUser().getUsername();
        String codeToSend = codingArea.getText();
        progressBar.setVisible(true);
        Core.Storage.setCodeToShow(codeToSend);
        Core.SocketManager.sendMessageObject(RequestTypes.COMPILE, new CompileRequest(codeToSend ,userName, question));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        CompiledQuestion question = Core.Storage.getQuestionToShow();
        questionLabel.setText(question.getQuestion());
    }
}
