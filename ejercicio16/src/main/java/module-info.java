module com.example.ejercicio16 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ejercicio16 to javafx.fxml;
    exports com.example.ejercicio16;
}