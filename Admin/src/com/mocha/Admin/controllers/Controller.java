package com.mocha.Admin.controllers;

import com.mocha.Admin.Transition;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * Created by E.Batuhan Kaynak on 28.4.2016.
 */

public class Controller {
    private Stage prevStage;

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
        new Transition(getPrevStage(), sceneName).changeScene();
    }
}
