package com.mocha.client.controllers;

import com.mocha.client.Core;
import com.mocha.client.models.requests.CompileResultRequest;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by E.Batuhan Kaynak on 24.4.2016.
 */
public class CodingMenuTestController extends CodingMenuController {

    @FXML TableView testTable;
    @FXML TableColumn testCaseColumn;
    @FXML TableColumn errorColumn;
    @FXML TableColumn passedColumn;

    private static final String tickSource = "../resources/images/tick_32.png";
    private static final String crossSource = "../resources/images/cross_32.png";

    private final ImageView tickImage = new ImageView(new Image(String.valueOf(getClass().getResource(tickSource))));
    private final ImageView crossImage = new ImageView(new Image(String.valueOf(getClass().getResource(crossSource))));

    private CompileResultRequest compileResultRequest;
    private ObservableList<MyCompileData> compileDatas;

    public CodingMenuTestController(){
        //super();
        compileResultRequest = Core.Storage.getCompileResultRequest();
        compileDatas = FXCollections.observableArrayList();
        /*
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
        });*/
        Scene scene = Core.Storage.getScene();
        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {

            }
        });
    }
    /*
    public void parseCompileData(){
        // TODO: 24.4.2016 get array size and run loop
        for (int i = 0; i < compileResultRequest.getCompilerResult().size(); i++)){
            String testCase = compileResultRequest;
            String errorString compileResultRequest;
            boolean passed = compileResultRequest;
            MyCompileData compileData;
            if (passed){
                compileData = new MyCompileData(testCase, errorString, tickImage));
            }
            else{
                compileData = new MyCompileData(testCase, errorString, crossImage));
            }
            compileDatas.add(compileData);
        }
    }*/

    final ObservableList<MyCompileData> data = FXCollections.observableArrayList(
            new MyCompileData("aba", "rip", tickImage),
            new MyCompileData("baaba", "rip", crossImage),
            new MyCompileData("Ziya", "Ortalama out of bounds", tickImage)
    );

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        super.initialize(location, resources);
        //parseCompileData();

        testCaseColumn.setCellValueFactory(new PropertyValueFactory<MyCompileData, String>("testCase"));
        errorColumn.setCellValueFactory(new PropertyValueFactory<MyCompileData, String>("error"));
        passedColumn.setCellValueFactory(new PropertyValueFactory<MyCompileData, ImageView>("passed"));

        testTable.setItems(data);
        //testTable.setItems(compileDatas);
    }

    /*
    private class MyIDEListener extends {

    }*/

    public static class MyCompileData {
        private final SimpleStringProperty testCase;
        private final SimpleStringProperty error;
        private final ImageView passed;

        private MyCompileData(String testCase, String  error, ImageView passed) {
            this.testCase = new SimpleStringProperty(testCase);
            this.error = new SimpleStringProperty(error);
            this.passed = passed;
        }

        public String getTestCase() {
            return testCase.get();
        }

        public String getError() {
            return error.get();
        }

        public ImageView getPassed() {
            return passed;
        }
    }
}

