package com.mocha.client.controllers;

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
    private URL location;
    private ResourceBundle recources;
    private boolean right;
    private boolean left;
    private boolean first;

    public OptionsController(){
        first = true;
    }

    @FXML void onLeftButtonClick(MouseEvent mouseEvent){
        left = true;
        initialize(location, recources);
    }

    @FXML void onRightButtonClick(MouseEvent mouseEvent){
        right = true;
        System.out.println("RIGHT BUTTON");
        initialize(location, recources);
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.location = location;
        this.recources = resources;

        System.out.println("IN INITIALIZE");

        System.out.println(first);

        if (first) {
            System.out.println("IN FIRST");
            imageList.get(0).setImage(new Image(String.valueOf(getClass().getResource("../resources/images/shopImages/Null.png"))));
            labelList.get(0).setText("");

            userThemes = new ArrayList<>();
            //userThemes.add("");
            userThemes.add("Red");
            userThemes.add("Blue");
            userThemes.add("Green");

            for (int i = 1; i - 1 < userThemes.size(); i++) {
                labelList.get(i).setText(userThemes.get(i - 1));
                String imageSource = String.valueOf(getClass().getResource("../resources/images/shopImages/" + userThemes.get(i - 1) + ".png"));
                imageList.get(i).setImage(new Image(imageSource));
            }
            first = false;
        }
        else if (right){
            System.out.println("IN RIGHT");
            for (int i = 0; i + 1< userThemes.size(); i++){
                //imageList.set(i, imageList.get(i + 1));
                imageList.get(i).setImage(imageList.get(i).getImage());
                labelList.get(i).setText(labelList.get(i).toString());
                //labelList.set(i, labelList.get(i + 1));
            }
            right = false;
        }
        else if (left){
            System.out.println("IN LEFT");
            for (int i = 0; i + 1< userThemes.size(); i++){
                imageList.set(i + 1, imageList.get(i));
                labelList.set(i + 1, labelList.get(i));
            }
            left = false;
        }
    }
}
