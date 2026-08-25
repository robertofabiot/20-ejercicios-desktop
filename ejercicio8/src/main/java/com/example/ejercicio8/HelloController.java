package com.example.ejercicio8;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.List;

public class HelloController {
    @FXML
    public TextField tfNumero1;
    @FXML
    public TextField tfNumero2;
    public Label lblResult;
    public Label lblHistory;
    @FXML
    private Label welcomeText;

    // Esto grita PROGRAMACIÓN FUNCIONAL, pero no me sé la sintaxis y
    // soy demasiado orgulloso para usar ia. Asi se va
    public void sum(ActionEvent actionEvent) {
        Double number1, number2 = getNumbers();
    }

    public void substract(ActionEvent actionEvent) {
    }

    public void mutiply(ActionEvent actionEvent) {
    }

    public void divide(ActionEvent actionEvent) {
    }
    
}
