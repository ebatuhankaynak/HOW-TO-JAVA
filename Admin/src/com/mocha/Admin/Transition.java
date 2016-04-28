package com.mocha.Admin;

import com.mocha.Admin.controllers.Controller;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by E.Batuhan Kaynak on 28.4.2016.
 */

public class Transition {

    private Stage stage;
    private Stage prevStage;

    public Transition(Stage prevStage, String fxml)
    {
        this.prevStage = prevStage;

        stage = new Stage();
        stage.setMinHeight(700);
        stage.setMinWidth(800);
        stage.setTitle("How To Java");

        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("resources/" + fxml + ".fxml"));
        Pane myPane = null;
        try {
            myPane = (Pane)myLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Controller controller = myLoader.getController();
        controller.setPrevStage(stage);
        Scene scene = new Scene(myPane);
        //Core.Storage.setScene(scene);

        String userTheme = "Green";
        String image = Main.class.getResource("resources/images/shopImages/" + userTheme + ".png").toExternalForm();
        myPane.setStyle("-fx-background-image: url('" + image + "'); " +
                "-fx-background-position: center center; " +
                "-fx-background-repeat: repeat;");
        stage.setScene(scene);
    }

    public void changeScene()
    {
        prevStage.close();
        stage.show();
    }
}
