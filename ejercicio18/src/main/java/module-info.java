module com.example.ejercicio18 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ejercicio18 to javafx.fxml;
    exports com.example.ejercicio18;
}