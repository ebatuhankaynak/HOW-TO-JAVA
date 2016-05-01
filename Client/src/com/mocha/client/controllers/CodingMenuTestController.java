package com.mocha.client.controllers;

import com.mocha.client.Core;
import com.mocha.client.JsonListenerCapsule.JsonListener;
import com.mocha.client.JsonListenerCapsule.RequestTypes;
import com.mocha.client.models.Questions.CompiledQuestion;
import com.mocha.client.models.Questions.CompiledQuestionContainer;
import com.mocha.client.models.requests.CompileResultRequest;
import com.mocha.client.models.results.CompileResults;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

/**
 * Created by E.Batuhan Kaynak on 24.4.2016.
 */
public class CodingMenuTestController extends CodingMenuController {

    @FXML TableView testTable;
    @FXML TableColumn testCaseColumn;
    @FXML TableColumn expectedColumn;
    @FXML TableColumn outputColumn;
    @FXML TableColumn passedColumn;
    @FXML Label awardLabel;
    @FXML TextArea codingArea;
    @FXML javafx.scene.control.Button nextQuestionButton;

    private boolean trueSoFar;
    private CompiledQuestionContainer questions;


    private static final String tickSource = "../resources/images/tick_32.png";
    private static final String crossSource = "../resources/images/cross_32.png";

    private CompileResultRequest compileResultRequest;
    private ObservableList<MyCompileData> compileDatas;

    public CodingMenuTestController(){
        compileResultRequest = Core.Storage.getCompileResultRequest();
        compileDatas = FXCollections.observableArrayList();
        trueSoFar = true;

        Core.JsonListenerManager.addJsonListener(RequestTypes.COMPILE_RESULT, new JsonListener<CompileResultRequest>() {
            @Override
            public void run(CompileResultRequest req) {
                CompileResults res = req.getResult();
                System.out.println(res);
                if (res == CompileResults.SUCCESS) {
                    Core.Storage.setCompileResultRequest(req);
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            goToScene("CodingMenuTest");
                        }
                    });
                } else if (res == CompileResults.FAILURE) {
                    System.out.println("Rip Compile");
                }
            }
        });
    }

    public void onNextQuestionButtonClick(){
        try{
            questions = Core.Storage.getQuestionContainer();
            Core.Storage.setQuestionToShow(questions.getQuestions().get(0));
            questions.getQuestions().remove(0);
            Core.Storage.setQuestionContainer(questions);
            Core.Storage.setQuestionToShow(questions.getQuestions().get(0));
            goToScene("CodingMenu");
        }
        catch (IndexOutOfBoundsException e){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Questions Completed!");
            alert.setHeaderText("Succes!");
            ButtonType okButton =  new ButtonType("Back to Topic Selection");
            alert.getButtonTypes().setAll(okButton);

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == okButton) {
                goToScene("TopicMenu");
            }
        }
    }

    public void parseCompileData(){
        for (int i = 0; i < compileResultRequest.getCompilerResults().length; i++){
            String testCase = ((CompiledQuestion) (Core.Storage.getQuestionToShow())).getTestCases()[i];
            String expected = ((CompiledQuestion) (Core.Storage.getQuestionToShow())).getTestCaseAnswers()[i];
            String output = compileResultRequest.getErrString()[i];
            boolean passed = compileResultRequest.getCompilerResults()[i];
            if (!passed){
                trueSoFar = false;
            }
            MyCompileData compileData;
            if (passed){
                compileData = new MyCompileData(testCase, expected, output, createTickImage());
            }
            else{
                compileData = new MyCompileData(testCase, expected, output, createCrossImage());
            }
            compileDatas.add(compileData);
        }
    }

    public ImageView createTickImage(){
        return new ImageView(new Image(String.valueOf(getClass().getResource(tickSource))));
    }

    public ImageView createCrossImage(){
        return new ImageView(new Image(String.valueOf(getClass().getResource(crossSource))));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        CompiledQuestion question = Core.Storage.getQuestionToShow();
        questionLabel.setText(question.getQuestion());
        awardLabel.setText("Coffee Bean award: " + String.valueOf(question.getCoffeeBeansawarded()));
        codingArea.setText(Core.Storage.getCodeToShow());

        parseCompileData();
        if (trueSoFar){
            nextQuestionButton.setVisible(true);
            nextQuestionButton.setDisable(false);
            awardLabel.setText("Coffee Beans Awarded!");
            System.out.println(Core.Storage.getUser().getTotalCoffeeBeans());
            Core.Storage.getUser().update(question.getId().getQuestionTopic(), question.getCoffeeBeansawarded());
            System.out.println(Core.Storage.getUser().getTotalCoffeeBeans());
        }

        testCaseColumn.setCellValueFactory(new PropertyValueFactory<MyCompileData, String>("testCase"));
        expectedColumn.setCellValueFactory(new PropertyValueFactory<MyCompileData, String>("expected"));
        outputColumn.setCellValueFactory(new PropertyValueFactory<MyCompileData, String>("output"));
        passedColumn.setCellValueFactory(new PropertyValueFactory<MyCompileData, ImageView>("passed"));

        testTable.setItems(compileDatas);
    }

    public  class MyCompileData {
        private final SimpleStringProperty testCase;
        private final SimpleStringProperty expected;
        private final SimpleStringProperty output;
        private final ImageView passed;

        private MyCompileData(String testCase, String expected, String output, ImageView passed) {
            this.testCase = new SimpleStringProperty(testCase);
            this.expected = new SimpleStringProperty(expected);
            this.output = new SimpleStringProperty(output);
            this.passed = passed;
        }

        public String getTestCase() {
            return testCase.get();
        }

        public String getOutput() {
            return output.get();
        }

        public ImageView getPassed() {
            return passed;
        }

        public String getExpected() {
            return expected.get();
        }
    }
}

