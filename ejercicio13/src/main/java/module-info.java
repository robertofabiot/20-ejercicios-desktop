module com.example.ejercicio13 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ejercicio13 to javafx.fxml;
    exports com.example.ejercicio13;
}