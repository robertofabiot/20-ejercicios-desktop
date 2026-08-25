package com.example.ejercicio8;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.List;

public class HelloController {

    List<String> results = new ArrayList<>();

    @FXML
    public TextField tfNumero1;
    @FXML
    public TextField tfNumero2;
    public Label lblResult;
    public Label lblHistory;
    @FXML
    private Label welcomeText;

    // Esto grita PROGRAMACIÓN FUNCIONAL, pero no me sé la sintaxis y
    // soy demasiado orgulloso para usar ia, así que se van sin DRY
    public void sum(ActionEvent actionEvent) {
        Double number1 = Double.parseDouble(tfNumero1.getText());
        Double number2 = Double.parseDouble(tfNumero2.getText());
        Double result = number1 + number2;
        results.add(number1 + " + " + number2);
        lblResult.setText(String.valueOf(result));
        lblHistory.setText(results.toString());
    }

    public void substract(ActionEvent actionEvent) {
        Double number1 = Double.parseDouble(tfNumero1.getText());
        Double number2 = Double.parseDouble(tfNumero2.getText());
        Double result = number1 - number2;
        results.add(number1 + " - " + number2);
        lblResult.setText(String.valueOf(result));
        lblHistory.setText(results.toString());
    }

    public void mutiply(ActionEvent actionEvent) {
        Double number1 = Double.parseDouble(tfNumero1.getText());
        Double number2 = Double.parseDouble(tfNumero2.getText());
        Double result = number1 * number2;
        results.add(number1 + " * " + number2);
        lblResult.setText(String.valueOf(result));
        lblHistory.setText(results.toString());
    }

    public void divide(ActionEvent actionEvent) {
        Double number1 = Double.parseDouble(tfNumero1.getText());
        Double number2 = Double.parseDouble(tfNumero2.getText());
        if(number2.equals(0.0)){
            lblResult.setText("Es en serio?");
            return;
        }
        Double result = number1 / number2;
        results.add(number1 + " / " + number2);
        lblResult.setText(String.valueOf(result));
        lblHistory.setText(results.toString());
    }

}
