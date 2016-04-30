package com.mocha.client;

import com.mocha.client.JsonListenerCapsule.RequestTypes;
import com.mocha.client.controllers.LoginController;
import com.mocha.client.models.requests.UpdateRequest;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * Created by E.Batuhan Kaynak on 30.3.2016.
 */

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("How To Java");
        primaryStage.setMinHeight(400);
        primaryStage.setMinWidth(400);

        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("resources/LoginScreen.fxml"));
        Pane myPane = (Pane)myLoader.load();

        LoginController loginController= (LoginController) myLoader.getController();
        loginController.setPrevStage(primaryStage);

        Scene myScene = new Scene(myPane);

        primaryStage.setScene(myScene);
        primaryStage.show();

        Platform.setImplicitExit(false);

        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                System.out.println("About to send UpdateRequest");
                Core.SocketManager.sendMessageObject(RequestTypes.UPDATE, new UpdateRequest(Core.Storage.getUser()));
            }
        });

        String selectedTheme = "Null";
        Core.Storage.setSelectedTheme(selectedTheme);
        String image = Main.class.getResource("resources/images/shopImages/" + selectedTheme + ".png").toExternalForm();
        myPane.setStyle("-fx-background-image: url('" + image + "'); " +
                "-fx-background-position: center center; " +
                "-fx-background-repeat: repeat;");

    }

    public static void main(String[] args) {
        launch(args);
    }
}
