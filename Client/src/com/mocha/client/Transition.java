package com.mocha.client;

import com.mocha.client.controllers.Controller;
import com.mocha.client.models.Questions.Question;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by E.Batuhan Kaynak on 31.3.2016.
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
        Core.Storage.setScene(scene);
        /*
        String image = Main.class.getResource("resources/images/Theme1.png").toExternalForm();
        myPane.setStyle("-fx-background-image: url('" + image + "'); " +
                "-fx-background-position: center center; " +
                "-fx-background-repeat: stretch;");*/
        stage.setScene(scene);
    }

    /*
    public Transition(Stage prevStage, String fxml, Question question)
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
        Controller controller = new CodingMenuController(question);
        controller.setPrevStage(stage);
        Scene scene = new Scene(myPane);
        stage.setScene(scene);
    }*/

    public Transition(Stage prevStage, String fxml, Question question)
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
        Core.Storage.setScene(scene);
        stage.setScene(scene);
    }

    public void changeScene()
    {
        prevStage.close();
        stage.show();
    }
}
