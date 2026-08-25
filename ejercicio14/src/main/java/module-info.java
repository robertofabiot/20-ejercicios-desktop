module com.example.ejercicio14 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ejercicio14 to javafx.fxml;
    exports com.example.ejercicio14;
}