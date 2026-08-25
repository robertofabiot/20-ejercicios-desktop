module com.example.ejercicio19 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ejercicio19 to javafx.fxml;
    exports com.example.ejercicio19;
}