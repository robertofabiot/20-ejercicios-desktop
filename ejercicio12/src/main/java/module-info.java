module com.example.ejercicio12 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ejercicio12 to javafx.fxml;
    exports com.example.ejercicio12;
}