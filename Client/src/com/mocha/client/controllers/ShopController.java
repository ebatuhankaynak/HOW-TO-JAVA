package com.mocha.client.controllers;

import com.mocha.client.Core;
import com.mocha.client.models.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created by E.Batuhan Kaynak on 17.4.2016.
 */

public class ShopController extends Controller implements Initializable{

    @FXML Label coffeeBeansLabel;

    @FXML ArrayList<Label> labelList;
    @FXML ArrayList<ImageView> imageList;

    private final String[] themeNames = {"Red", "Blue", "Green"};
    private final String[] imageSources = {
        "../resources/images/shopImages/Red.png",
        "../resources/images/shopImages/Blue.png",
        "../resources/images/shopImages/Green.png"
    };

    public ShopController(){

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        User user = Core.Storage.getUser();
        coffeeBeansLabel.setText("You Have " + user.getTotalCoffeeBeans() + " Coffee Beans");

        for (int i = 0; i < themeNames.length; i++){
            labelList.get(i).setText(themeNames[i]);
        }

        for (int i = 0; i < themeNames.length; i++){
            imageList.get(i).setImage(new Image(String.valueOf(getClass().getResource(imageSources[i]))));
        }
    }
}
