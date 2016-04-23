package com.mocha.client.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * Created by E.Batuhan Kaynak on 17.4.2016.
 */

public class ProfileController extends Controller {

    @FXML Label nameLabel;
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

}
