module com.example.ejercicio9 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ejercicio9 to javafx.fxml;
    exports com.example.ejercicio9;
}