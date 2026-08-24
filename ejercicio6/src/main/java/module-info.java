module com.example.ejercicio6 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ejercicio6 to javafx.fxml;
    exports com.example.ejercicio6;
}