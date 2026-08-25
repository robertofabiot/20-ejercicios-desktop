module com.example.ejercicio8 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ejercicio8 to javafx.fxml;
    exports com.example.ejercicio8;
}