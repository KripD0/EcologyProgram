package com.example.lab_5_ecology.controllers;

import com.example.lab_5_ecology.SceneChanger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.io.IOException;

public class AirController {
    int k[] = new int[5];
    double distanse, rvk = 1, rvk_NOx = 1;
    double Co[] = {0.8,4.2,4.8,5.1,3.6};
    double No[] = {0.3,1.6,5.8,6.8,4.3};
    double Ch[] = {0.24,0.63,1.4,1.80,0.4};
    double soot[] = {0.005,0.034,0.34,0.40,0.14};
    double SO2[] = {0.006,0.013,0.024,0.035,0.020};
    double CH2O[] = {0.0014,0.0023,0.006,0.007,0.002};
    double C20H12[] = {0.00000016,0.00000018,0.00000054,0.00000066,0.00000018};
    double CoOutput, NoOunput, ChOutput, sootOutput, So2Output, formaldehyde, benzopyrene;

    ObservableList<String> langs = FXCollections.observableArrayList("5", "10" ,"15", "20", "25", "30", "35", "40", "45", "50", "60", "70", "80", "100", "110", "120");

    private SceneChanger sceneChanger = new SceneChanger();

    @FXML
    private TextField Passenger;
    @FXML
    private TextField Van;
    @FXML
    private TextField Freight_under;
    @FXML
    private TextField Freight_upper;
    @FXML
    private TextField Bus;
    @FXML
    private TextField Distanse;
    @FXML
    private TextField CO;
    @FXML
    private TextField NO;
    @FXML
    private TextField CH;
    @FXML
    private TextField Soot;
    @FXML
    private TextField SO;
    @FXML
    private TextField Formaldehyde;
    @FXML
    private TextField Benzopyrene;
    @FXML
    public ComboBox<String> Speed_combobox;

    @FXML
    private void clickOnImageBack(){
        sceneChanger.changeScene("scenes/main.fxml");
    }

    @FXML
    protected void onClearButtonClick() {
        Passenger.clear();
        Van.clear();
        Freight_under.clear();
        Freight_upper.clear();
        Bus.clear();
        Distanse.clear();
        CO.clear();
        NO.clear();
        CH.clear();
        Soot.clear();
        SO.clear();
        Formaldehyde.clear();
        Benzopyrene.clear();
    }
    @FXML
    protected int onCalculateButtonClick() throws IOException {
        if(Passenger.getText().isEmpty() || Van.getText().isEmpty() || Freight_under.getText().isEmpty() || Freight_upper.getText().isEmpty() ||
                Bus.getText().isEmpty() || Distanse.getText().isEmpty() || Speed_combobox.getSelectionModel().isEmpty()){
            sceneChanger.createExeptionScene();
            return 1;
        }
        CoOutput = NoOunput = ChOutput = sootOutput = So2Output = formaldehyde = benzopyrene = 0;
        k[0] = Integer.parseInt(Passenger.getText());
        k[1] = Integer.parseInt(Van.getText());
        k[2] = Integer.parseInt(Freight_under.getText());
        k[3] = Integer.parseInt(Freight_upper.getText());
        k[4] = Integer.parseInt(Bus.getText());
        distanse = Integer.parseInt(Distanse.getText());
        switch (Speed_combobox.getSelectionModel().getSelectedIndex()){
            case 0: rvk = 1.4;rvk_NOx = 1.0;break;
            case 1: rvk = 1.35;rvk_NOx = 1.0;break;
            case 2: rvk = 1.30;rvk_NOx = 1.0;break;
            case 3: rvk = 1.20;rvk_NOx = 1.0;break;
            case 4: rvk = 1.10;rvk_NOx = 1.0;break;
            case 5: rvk = 1.00;rvk_NOx = 1.0;break;
            case 6: rvk = 0.90;rvk_NOx = 1.0;break;
            case 7: rvk = 0.75;rvk_NOx = 1.0;break;
            case 8: case 13: rvk = 0.65;rvk_NOx = 1.0;break;
            case 9: case 12: rvk = 0.50;rvk_NOx = 1.0;break;
            case 10: rvk = 0.30;rvk_NOx = 1.0;break;
            case 11: rvk = 0.40;rvk_NOx = 1.0;break;
            case 14: rvk = 0.75;rvk_NOx = 1.2;break;
            case 15: rvk = 0.95;rvk_NOx = 1.5;break;
            default: break;
        }
        for(int i = 0; i < 5; i++){
            CoOutput += Co[i]*k[i]*rvk;
            NoOunput += No[i]*rvk_NOx*k[i]*rvk;
            ChOutput += Ch[i]*k[i]*rvk;
            sootOutput += soot[i]*k[i]*rvk;
            So2Output += SO2[i]*k[i]*rvk;
            formaldehyde += CH2O[i]*k[i]*rvk;
            benzopyrene += C20H12[i]*k[i]*rvk;
        }
        CoOutput *= distanse/1200;
        NoOunput *= distanse/1200;
        ChOutput *= distanse/1200;
        sootOutput *= distanse/1200;
        So2Output *= distanse/1200;
        formaldehyde *= distanse/1200;
        benzopyrene *= distanse/1200;
        CO.setText(String.valueOf(String.format("%.5f", CoOutput)));
        NO.setText(String.valueOf(String.format("%.5f", NoOunput)));
        CH.setText(String.valueOf(String.format("%.5f", ChOutput)));
        Soot.setText(String.valueOf(String.format("%.5f", sootOutput)));
        SO.setText(String.valueOf(String.format("%.5f", So2Output)));
        Formaldehyde.setText(String.valueOf(String.format("%.5f", formaldehyde)));
        Benzopyrene.setText(String.valueOf(String.format("%.7f", benzopyrene)));
        return 1;
    }


    @FXML
    public void initialize() {
        Speed_combobox.getItems().addAll(langs);
    }
}