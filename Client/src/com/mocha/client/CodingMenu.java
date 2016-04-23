package com.mocha.client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CodingMenu extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("resources/CodingMenu.fxml"));
        primaryStage.setTitle("How To Java!");
        primaryStage.setMinHeight(500);
        primaryStage.setMinWidth(500);
        primaryStage.setScene(new Scene(root, 750, 600));
        primaryStage.getScene().onMouseClickedProperty();

        primaryStage.show();
    }
}
