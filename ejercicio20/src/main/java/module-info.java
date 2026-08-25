module com.example.ejercicio20 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ejercicio20 to javafx.fxml;
    exports com.example.ejercicio20;
}