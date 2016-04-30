package com.mocha.client.controllers;

import com.mocha.client.Core;
import com.mocha.client.models.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

/**
 * Created by E.Batuhan Kaynak on 17.4.2016.
 */

public class ProfileController extends Controller implements Initializable{

    @FXML Label nameLabel;
    @FXML Label currentCoffeeBeansLabel;
    @FXML Label beansTodayLabel;
    @FXML Label totalBeansLabel;
    @FXML BarChart<String, Integer> progressGraph;
    @FXML CategoryAxis xAxis;
    @FXML NumberAxis yAxis;

    private ObservableList<String> topicNames = FXCollections.observableArrayList();
    private XYChart.Series<String, Integer> series = new XYChart.Series<>();

    private final String[] topics = {"DATA_TYPES", "METHODS", "CLASS"};

    public ProfileController()
    {
        //setProgressGraph();
    }

    @FXML
    private void onMainMenuButtonClick(MouseEvent mouseEvent){
        goToScene("MainMenu");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        User user = Core.Storage.getUser();
        nameLabel.setText(user.getUsername());
        currentCoffeeBeansLabel.setText("Current Coffee Beans: " + String.valueOf(user.getTotalCoffeeBeans()));
        //beansTodayLabel.setText();
        //totalBeansLabel.setText(String.valueOf(user.getTotalScore()));

        topicNames.addAll(Arrays.asList(topics));
        xAxis.setCategories(topicNames);

        for (int i = 0; i < topics.length; i++) {
            series.getData().add(new XYChart.Data<>(topics[i], user.getScore(topics[i])));
        }
        progressGraph.getData().add(series);
    }
}
