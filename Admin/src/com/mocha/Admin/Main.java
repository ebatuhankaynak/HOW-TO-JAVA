package com.mocha.Admin;

/**
 * Created by E.Batuhan Kaynak on 28.4.2016.
 */

import com.mocha.Admin.controllers.LoginController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("How To Java");
        primaryStage.setMinHeight(400);
        primaryStage.setMinWidth(400);

        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("resources/LoginScreen.fxml"));
        Pane myPane = null;
        try {
            myPane = (Pane)myLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        LoginController loginController = myLoader.getController();
        loginController.setPrevStage(primaryStage);

        Scene myScene = new Scene(myPane);

        primaryStage.setScene(myScene);
        primaryStage.show();
    }
}
