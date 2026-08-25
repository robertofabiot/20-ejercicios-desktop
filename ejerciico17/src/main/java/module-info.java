module com.example.ejercicio17 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ejercicio17 to javafx.fxml;
    exports com.example.ejercicio17;
}