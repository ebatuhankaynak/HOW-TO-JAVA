package com.mocha.client.controllers;


import com.mocha.client.Core;
import com.mocha.client.models.Questions.Question;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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
        //question = TopicMenuController.questionBadDesign;
        question = Core.Storage.getQuestionToShow();
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
        goToScene("CodingMenuTest");
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
        Question question = Core.Storage.getQuestionToShow();
        questionLabel.setText(question.getQuestion());
    }
}