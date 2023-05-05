package com.example.lab_5_ecology.controllers;

import com.example.lab_5_ecology.SceneChanger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.io.IOException;

public class TerraController {

    private SceneChanger sceneChanger = new SceneChanger();

    @FXML
    private TextField averageAnnualLossesField;

    @FXML
    private TextField cropManagementCoefficientField;

    @FXML
    private ComboBox<Integer> densityCombobox;

    @FXML
    private TextField erosionRateField;

    @FXML
    private ComboBox<Integer> erosionSusceptibilityFactorCombobox;

    @FXML
    private TextField massOfErodedSoilField;

    @FXML
    private TextField periodOfTimeField;

    @FXML
    private TextField residueRatioField;

    @FXML
    private TextField slopeLengthField;

    @FXML
    private TextField slopeSteepnessField;

    @FXML
    private TextField soilDepthField;

    @FXML
    private TextField squareField;

    @FXML
    private TextField supportPracticeRatiosField;

    @FXML
    private int onCalculateButtonClick() throws IOException {
        if(cropManagementCoefficientField.getText().isEmpty() || periodOfTimeField.getText().isEmpty() ||
                periodOfTimeField.getText().isEmpty() || residueRatioField.getText().isEmpty() || slopeLengthField.getText().isEmpty() || slopeSteepnessField.getText().isEmpty() ||
                soilDepthField.getText().isEmpty() || squareField.getText().isEmpty() || supportPracticeRatiosField.getText().isEmpty() || densityCombobox.getSelectionModel().isEmpty() || erosionSusceptibilityFactorCombobox.getSelectionModel().isEmpty())
        {
            sceneChanger.createExeptionScene();
            return 1;
        }
        calculatePeriod(calculateVolume());
        calculateAverage();
        return 1;
    }

    @FXML
    private void onClearButtonClick(){
        averageAnnualLossesField.clear();
        cropManagementCoefficientField.clear();
        erosionRateField.clear();
        massOfErodedSoilField.clear();
        periodOfTimeField.clear();
        residueRatioField.clear();
        slopeLengthField.clear();
        slopeSteepnessField.clear();
        soilDepthField.clear();
        squareField.clear();
        supportPracticeRatiosField.clear();
    }

    @FXML
    private void initialize(){
        ObservableList<Integer> listDensity = FXCollections.observableArrayList(105, 110, 115, 120, 125, 130);
        ObservableList<Integer> listErrousion = FXCollections.observableArrayList(41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55);
        densityCombobox.getItems().addAll(listDensity);
        erosionSusceptibilityFactorCombobox.getItems().addAll(listErrousion);
    }

    @FXML
    private void clickOnImageBack(){
        sceneChanger.changeScene("scenes/main.fxml");
    }

    private double calculateVolume(){
        double result;
        result = Double.parseDouble(squareField.getText()) * Double.parseDouble(soilDepthField.getText()) * densityCombobox.getSelectionModel().getSelectedItem();
        massOfErodedSoilField.setText(String.valueOf(result));
        return result;
    }

    private void calculatePeriod(double volume){
        double result;
        result = volume / Double.parseDouble(periodOfTimeField.getText());
        erosionRateField.setText(String.valueOf(result));
    }

    private void calculateAverage(){
        averageAnnualLossesField.setText(String.valueOf(
                (Double.parseDouble(residueRatioField.getText()) / 100) * Double.parseDouble(slopeLengthField.getText()) *
                        Double.parseDouble(slopeSteepnessField.getText()) * (Double.parseDouble(cropManagementCoefficientField.getText()) / 100) *
                        (Double.parseDouble(supportPracticeRatiosField.getText()) / 100) * ((double) erosionSusceptibilityFactorCombobox.getSelectionModel().getSelectedItem() / 100)
        ));
    }
}
