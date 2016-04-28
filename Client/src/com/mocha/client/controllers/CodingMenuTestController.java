package com.mocha.client.controllers;

import com.mocha.client.Core;
import com.mocha.client.JsonListenerCapsule.JsonListener;
import com.mocha.client.JsonListenerCapsule.RequestTypes;
import com.mocha.client.models.Questions.CompiledQuestion;
import com.mocha.client.models.Questions.Question;
import com.mocha.client.models.requests.CompileResultRequest;
import com.mocha.client.models.results.CompileResults;
import com.sun.javafx.webkit.Accessor;
import com.sun.webkit.WebPage;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Worker;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.awt.*;
import java.net.URL;
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
    //@FXML TextArea codingArea;
    //@FXML HTMLEditor htmlEditor;
    @FXML WebView webView;

    private WebPage webPage;

    private static final String tickSource = "../resources/images/tick_32.png";
    private static final String crossSource = "../resources/images/cross_32.png";

    //private final ImageView tickImage = new ImageView(new Image(String.valueOf(getClass().getResource(tickSource))));
    //private final ImageView crossImage = new ImageView(new Image(String.valueOf(getClass().getResource(crossSource))));

    private CompileResultRequest compileResultRequest;
    private ObservableList<MyCompileData> compileDatas;

    public CodingMenuTestController(){
        compileResultRequest = Core.Storage.getCompileResultRequest();
        compileDatas = FXCollections.observableArrayList();

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
        Scene scene = Core.Storage.getScene(); // NO NEED FOR THIS NOW(I THINK)
    }

    public void parseCompileData(){
        for (int i = 0; i < compileResultRequest.getCompilerResults().length; i++){
            String testCase = ((CompiledQuestion) (Core.Storage.getQuestionToShow())).getTestCases()[i];
            String expected = ((CompiledQuestion) (Core.Storage.getQuestionToShow())).getTestCaseAnswers()[i];
            String output = compileResultRequest.getErrString()[i];
            boolean passed = compileResultRequest.getCompilerResults()[i];
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
        //super.initialize(location, resources);
        Question question = Core.Storage.getQuestionToShow();
        questionLabel.setText(question.getQuestion());

        parseCompileData();

        testCaseColumn.setCellValueFactory(new PropertyValueFactory<MyCompileData, String>("testCase"));
        expectedColumn.setCellValueFactory(new PropertyValueFactory<MyCompileData, String>("expected"));
        outputColumn.setCellValueFactory(new PropertyValueFactory<MyCompileData, String>("output"));
        passedColumn.setCellValueFactory(new PropertyValueFactory<MyCompileData, ImageView>("passed"));

        testTable.setItems(compileDatas);

        WebEngine webEngine = webView.getEngine();
        webPage = Accessor.getPageFor(webEngine);
        String url = CodingMenuTestController.class.getResource("IDE.html").toExternalForm();
        webEngine.load(url);
        webPage.executeScript(webPage.getMainFrame(), "document.body.innerHTML = " + Core.Storage.getCodeToShow() + ";");

        //webView.addEventHandler(KeyEvent.KEY_RELEASED, event -> executeScript());
        try {
            webView.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>()
                {
                    @Override
                    public void handle(KeyEvent keyEvent)
                    {
                        if(keyEvent.getCode() == KeyCode.TAB)
                        {
                            executeScript();
                            keyEvent.consume();
                        }
                    }
                });
            webView.addEventFilter(KeyEvent.KEY_RELEASED, new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent event) {
                    String currentText = (String) webPage.executeScript(webPage.getMainFrame(), "document.body.innerHTML");
                    System.out.println(currentText);
                    String newText = "\"" + getBluePublic(currentText) + "\"";
                    webPage.executeScript(webPage.getMainFrame(), "document.body.innerHTML = " + newText + ";");
                }
            });
            setCaret();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void executeScript(){
        webPage.executeScript(webPage.getMainFrame(), "document.body.innerHTML = document.body.innerHTML + \"&emsp;\" + \"ZA\"");
    }

    public void setCaret(){
        webPage.executeScript(webPage.getMainFrame(), "range = document.createRange();" +
                "range.selectNodeContents(document.body);" +
                "range.collapse(false);" +
                "selection = window.getSelection();" +
                "selection.removeAllRanges();" +
                "selection.addRange(range);");
    }

    public static class MyCompileData {
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

