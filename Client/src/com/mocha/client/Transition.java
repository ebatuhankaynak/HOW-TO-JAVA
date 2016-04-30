package com.mocha.client;

import com.mocha.client.JsonListenerCapsule.RequestTypes;
import com.mocha.client.controllers.Controller;
import com.mocha.client.models.Questions.Question;
import com.mocha.client.models.requests.UpdateRequest;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

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

        Platform.setImplicitExit(false);

        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                System.out.println("About to send UpdateRequest");
                Core.SocketManager.sendMessageObject(RequestTypes.UPDATE, new UpdateRequest(Core.Storage.getUser()));
            }
        });

        String userTheme = Core.Storage.getSelectedTheme();
        String image = Main.class.getResource("resources/images/shopImages/" + userTheme + ".png").toExternalForm();
        myPane.setStyle("-fx-background-image: url('" + image + "'); " +
                "-fx-background-position: center center; " +
                "-fx-background-repeat: repeat;");
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
