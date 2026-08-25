module com.example.ejercicio10 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ejercicio10 to javafx.fxml;
    exports com.example.ejercicio10;
}