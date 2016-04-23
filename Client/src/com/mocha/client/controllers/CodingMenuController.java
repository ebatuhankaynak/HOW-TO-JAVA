package com.mocha.client.controllers;


import com.mocha.server.models.Questions.Question;
import com.mocha.server.models.Questions.QuestionContainer;
import com.mocha.server.models.Topic;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by E.Batuhan Kaynak on 8.4.2016.
 */

public class CodingMenuController extends Controller implements Initializable {

    @FXML Label questionTitle;
    @FXML Label questionLabel;

    private Question question;


    public CodingMenuController(){
        System.out.println(TopicMenuController.questionBadDesign);
        question = TopicMenuController.questionBadDesign;
        System.out.println("CODING MENU CONTROLLER");
        System.out.println(question);
    }

    /*
    public CodingMenuController(Question question)
    {
        this();
        this.question = question;
        //setUpCodingMenu();
    }*/

    @FXML
    public void onCompileButtonClick(MouseEvent mouseEvent)
    {
        //sendCodeToServer();
    }

    public void setUpCodingMenu()
    {
        //questionTitle = ;
        //question.getQuestion()
        //quesitionLabel = new Label("zaa");
    }

    /*
    public void sendCodeToServer()
    {
        Core.JsonListenerManager.addJsonListener(RequestTypes.COMPILE_RESULT, new JsonListener<CompileResultRequest>() {
            @Override
            public void run(CompileResultRequest req) {
                CompileResults res = req.getResult();
            }
        });
    }*/

    /*public void goToCodingMenu() {
        new Transition(getPrevStage(), "CodingMenu").changeScene();
    }*/

    @FXML
    public void onTopicMenuButtonClick(MouseEvent mouseEvent)
    {
        goToScene("TopicMenu");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("INSIDE INITIALIZE");
        //setUpCodingMenu();
        //questionLabel = new Label();
        System.out.println(TopicMenuController.questionBadDesign);
        Question q = TopicMenuController.questionBadDesign;
        System.out.println("INITIALIZ ICNE GELDI MI?");
        System.out.println(q);
        questionLabel.setText(q.getQuestion());
    }
}
