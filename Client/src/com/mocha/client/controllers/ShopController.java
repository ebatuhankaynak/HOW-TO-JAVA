package com.mocha.client.controllers;

import com.mocha.client.Core;
import com.mocha.client.models.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

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
    @FXML ArrayList<Button> buttonList;

    private User user;

    private static final String tickSource = "../resources/images/tick_32.png";
    private final String[] themeNames = {"Red", "Blue", "Green"};
    private final String[] imageSources = {
        "../resources/images/shopImages/Red.png",
        "../resources/images/shopImages/Blue.png",
        "../resources/images/shopImages/Green.png"
    };

    public ShopController(){
        user = Core.Storage.getUser();
    }
    @FXML
    public void onBuyButtonClick(MouseEvent mouseEvent){
        Button clickedButton = (Button) mouseEvent.getSource();
        Core.Storage.getUser().addTheme(themeNames[Integer.parseInt(clickedButton.getId())]);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        coffeeBeansLabel.setText("You Have " + user.getTotalCoffeeBeans() + " Coffee Beans");

        for (int i = 0; i < themeNames.length; i++){
            labelList.get(i).setText(themeNames[i]);
        }

        for (int i = 0; i < themeNames.length; i++){
            if (!(user.getThemes().contains(themeNames[i]))) {
                imageList.get(i).setImage(new Image(String.valueOf(getClass().getResource(imageSources[i]))));
            }
            else{
                imageList.get(i).setImage(new Image(String.valueOf(getClass().getResource(tickSource))));
            }
        }

        // TODO: 29.4.2016 CANNOT ADD THEMES TO USER BECAUSE F!#K DATABASE

        for (int i = 0; i < themeNames.length; i++){
            if((user.getThemes().contains(themeNames[i]))){
                buttonList.get(i).setVisible(false);
                buttonList.get(i).setText("Sold!");
            }
        }
    }
}
