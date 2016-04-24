package com.mocha.client.controllers;

import com.mocha.client.Core;
import com.mocha.client.models.Questions.Question;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

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

    final ObservableList<MyTableData> data = FXCollections.observableArrayList(
            new MyTableData("aba", "rip", "X"),
            new MyTableData("baaba", "rip", "X"),
            new MyTableData("Ziya", "Ortalama out of bounds", "X")
    );

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //testCaseColumn = new TableColumn("Test Case");
        testCaseColumn.setCellValueFactory(new PropertyValueFactory<MyTableData, String>("testCase"));
        errorColumn.setCellValueFactory(new PropertyValueFactory<MyTableData, String>("error"));
        passedColumn.setCellValueFactory(new PropertyValueFactory<MyTableData, String>("passed"));

        //errorColumn = new TableColumn("Error");

        testTable.setItems(data);
    }

    public static class MyTableData{
        private final SimpleStringProperty testCase;
        private final SimpleStringProperty error;
        private final SimpleStringProperty passed;

        private MyTableData(String testCase, String  error, String passed) {
            this.testCase = new SimpleStringProperty(testCase);
            this.error = new SimpleStringProperty(error);
            this.passed = new SimpleStringProperty(passed);
        }

        public String getTestCase() {
            return testCase.get();
        }

        public String getError() {
            return error.get();
        }

        public String getPassed() {
            return passed.get();
        }
    }
}

