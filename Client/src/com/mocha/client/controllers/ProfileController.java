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
import java.util.ResourceBundle;

/**
 * Created by E.Batuhan Kaynak on 17.4.2016.
 */

public class ProfileController extends Controller implements Initializable{

    @FXML Label nameLabel;
    @FXML Label currentCoffeeBeansLabel;
    @FXML Label beansTodayLabel;
    @FXML Label totalBeansLabel;
    @FXML BarChart progressGraph;

    final CategoryAxis xAxis;
    final NumberAxis yAxis;
    final BarChart.Series<String, Number> series1 =  new BarChart.Series<String, Number>();
    ObservableList<XYChart.Series<String, Number>> barChartData = FXCollections.observableArrayList();
    ObservableList<XYChart.Series<String, Number>> stackBarChartData = FXCollections.observableArrayList();




    public ProfileController()
    {
        xAxis = new CategoryAxis();
        yAxis = new NumberAxis();
        progressGraph = new BarChart(xAxis, yAxis);
        setProgressGraph();
    }

    public void setProgressGraph()
    {
        series1.setName("2001");
        series1.getData().add(new XYChart.Data<String, Number>("blah", 25601.34));

        barChartData.add(series1);
        progressGraph.setData(barChartData);
    }

    /*
    @FXML ImageView profileImage;

    public ProfileController(){
        setProfileImage();
    }

    @FXML
    public void setProfileImage() {
        profileImage.setImage("../resources/images/java.png"));
    }*/

    @FXML
    private void onMainMenuButtonClick(MouseEvent mouseEvent){
        goToScene("MainMenu");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        User user = Core.Storage.getUser();
        nameLabel.setText(user.getUsername());
        currentCoffeeBeansLabel.setText("Current Coffee Beans: " + String.valueOf(user.getCoffeeBeans()));
    }
}
