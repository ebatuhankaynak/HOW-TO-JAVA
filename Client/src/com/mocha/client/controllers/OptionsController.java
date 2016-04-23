package com.mocha.client.controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.util.Optional;

/**
 * Created by E.Batuhan Kaynak on 17.4.2016.
 */

public class OptionsController extends Controller {

    @FXML Label versionLabel;

    @FXML
    public void onAboutTheDevsButtonClick(MouseEvent mouseEvent)
    {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("About the Developers!");
        alert.setHeaderText("Very Coders \n     such java \n            Wow");

        ButtonType okButton =  new ButtonType("Ok!");
        alert.getButtonTypes().setAll(okButton);

        alert.setGraphic(new ImageView(new Image(String.valueOf(getClass().getResource("../resources/images/Ziya2.png")))));

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == okButton) {
        }
    }
}
