package com.mocha.client.controllers;

import com.mocha.client.Core;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.util.Optional;

/**
 * Created by E.Batuhan Kaynak on 28.3.2016.
 */

public class MainMenuController extends Controller {
    @FXML
    private void onPracticeButtonClick(MouseEvent mouseEvent){
        goToScene("TopicMenu");
    }

    @FXML
    private void onProfileButtonButtonClick(MouseEvent mouseEvent){
        goToScene("Profile");
    }

    @FXML
    private void onDiagnosticTestButtonClick(MouseEvent mouseEvent){
        goToScene("DiagnosticTest");
    }

    @FXML
    private void onShopButtonClick(MouseEvent mouseEvent){
        goToScene("Shop");
    }

    @FXML
    private void onOptionsButtonClick(MouseEvent mouseEvent){
        goToScene("Options");
    }

    @FXML
    private void onExitButtonClick(MouseEvent mouseEvent) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Exit Program?");

        //alert.setHeaderText("Exit application");
        //alert.setContentText("Are you sure you want to quit How To Java?");
        alert.setHeaderText("Are you sure you want to quit How To Java?");

        ButtonType yesButton =  new ButtonType("Yes");
        ButtonType noButton =  new ButtonType("No");
        alert.getButtonTypes().setAll(yesButton, noButton);

        alert.setGraphic(new ImageView(new Image(String.valueOf(getClass().getResource("../resources/images/java.png")))));

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == yesButton) {
            //Platform.exit();
            System.exit(0);
        }
    }
}
