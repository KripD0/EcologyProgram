module com.example.lab_5_ecology {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.lab_5_ecology to javafx.fxml;
    exports com.example.lab_5_ecology.controllers;
    opens com.example.lab_5_ecology.controllers to javafx.fxml;
    exports com.example.lab_5_ecology;
}