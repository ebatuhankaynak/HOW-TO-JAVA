package com.mocha.client.controllers;

import com.mocha.client.Core;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

/**
 * Created by E.Batuhan Kaynak on 17.4.2016.
 */

public class OptionsController extends Controller implements Initializable{

    @FXML Label versionLabel;

    @FXML ArrayList<ImageView> imageList;
    @FXML ArrayList<Label> labelList;

    private ArrayList<String> userThemes;
    private int seperatorIndex;

    public OptionsController(){
        seperatorIndex = 0;
    }

    @FXML void onLeftButtonClick(MouseEvent mouseEvent){
        seperatorIndex--;
        seperatorIndex--;
        changeImages();
        seperatorIndex++;
    }

    @FXML void onRightButtonClick(MouseEvent mouseEvent){
        changeImages();
        seperatorIndex++;
    }

    public void changeImages(){
        if (seperatorIndex < 0){
            seperatorIndex = 0;
        }
        else if (seperatorIndex > userThemes.size()){
            seperatorIndex = userThemes.size();
        }
        for (int i = 0; i + seperatorIndex < userThemes.size(); i++){
            if (seperatorIndex == 0 ) {
                //labelList.get(i).setText(userThemes.get(seperatorIndex + i));
                labelList.get(0).setText("");
            }
            labelList.get(i).setText(userThemes.get(seperatorIndex + i));
            String imageSource = String.valueOf(getClass().getResource("../resources/images/shopImages/" + userThemes.get(seperatorIndex + i) + ".png"));
            imageList.get(i).setImage(new Image(imageSource));
        }
    }

    @FXML
    public void onChangeButtonClick(MouseEvent mouseEvent){
        Core.Storage.setSelectedTheme(userThemes.get(seperatorIndex));
        goToScene("Options");
    }

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

    /*
    public void reformUserThemes(){
        String currentTheme = Core.Storage.getSelectedTheme();
        for (int i = 0; i < )
    }*/

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        userThemes = new ArrayList<>();
        userThemes.add(Core.Storage.getSelectedTheme());
        userThemes.add("Red");
        userThemes.add("Blue");
        userThemes.add("Green");
        userThemes.add("White");

        for (int i = 0; i < userThemes.size(); i++) {
            if (i != 0) {
                labelList.get(i).setText(userThemes.get(i));
            }
            else {
                labelList.get(i).setText("");
            }
            String imageSource = String.valueOf(getClass().getResource("../resources/images/shopImages/" + userThemes.get(i) + ".png"));
            imageList.get(i).setImage(new Image(imageSource));
        }
        seperatorIndex++;
    }
}
