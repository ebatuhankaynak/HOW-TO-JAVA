package com.mocha.client.controllers;

import com.mocha.client.Transition;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * Created by E.Batuhan Kaynak on 31.3.2016.
 */

public class Controller {
    private Stage prevStage;
    private Scene scene;

    public void setPrevStage(Stage prevStage){
        this.prevStage = prevStage;
    }

    public Stage getPrevStage() {
        return prevStage;
    }

    @FXML
    private void onMainMenuButtonClick(MouseEvent mouseEvent){
        goToScene("MainMenu");
    }

    public void goToScene(String sceneName)
    {
       //Transition transition = new Transition(getPrevStage(), sceneName);
        new Transition(getPrevStage(), sceneName).changeScene();
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }
}
