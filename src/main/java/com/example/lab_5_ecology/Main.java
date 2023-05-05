package com.example.lab_5_ecology;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("scenes/main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 650, 360);
        Image ico = new Image(getClass().getResourceAsStream("images/icon.png"));
        stage.getIcons().add(ico);
        stage.setTitle("Экомониторинг");
        stage.setScene(scene);
        stage.show();
        SceneChanger sceneChanger = new SceneChanger(stage);
    }

    public static void main(String[] args) {
        launch();
    }
}