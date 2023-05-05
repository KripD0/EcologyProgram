package com.example.lab_5_ecology.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ExeptionSceneController {

    @FXML
    private Label label;

    @FXML
    private void initialize(){
        label.setWrapText(true);
    }

}
