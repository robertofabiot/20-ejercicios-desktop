module com.example.ejercicio5 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ejercicio5 to javafx.fxml;
    exports com.example.ejercicio5;
}