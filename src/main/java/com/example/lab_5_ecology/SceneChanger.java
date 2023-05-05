package com.example.lab_5_ecology;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneChanger {

    private static Stage stage;

    public SceneChanger(Stage stage){
        this.stage = stage;
    }

    public SceneChanger(){
    }

    public void changeScene(String nameScene){
        try {
            Parent root = FXMLLoader.load(getClass().getResource(nameScene));
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createExeptionScene() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("scenes/exeptionScene.fxml"));
        Stage stage = new Stage();
        Image image = new Image(getClass().getResourceAsStream("images/yzbek.jpg"));
        stage.getIcons().add(image);
        stage.setScene(new Scene(root));
        stage.show();
    }
}
