package com.example.lab_5_ecology.controllers;

import com.example.lab_5_ecology.SceneChanger;
import javafx.fxml.FXML;

public class MenuController {

    private SceneChanger sceneChanger = new SceneChanger();

    @FXML
    private void switchToAir() {
        sceneChanger.changeScene("scenes/airPollution.fxml");
    }

    @FXML
    private void switchToTerra() {
        sceneChanger.changeScene("scenes/terraPollution.fxml");
    }

}
