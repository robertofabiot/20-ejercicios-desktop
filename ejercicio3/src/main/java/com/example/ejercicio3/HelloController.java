package com.example.ejercicio3;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {

    Data data = new Data();

    @FXML
    private TextField tfNumber;

    @FXML
    private Button btnAdd;

    @FXML
    private Label originalNumbers;

    @FXML
    private Label sortedNumbers;

    public void addNumber(){
        int number = Integer.parseInt(tfNumber.getText());
        data.addNumber(number);
        tfNumber.setText("");
        originalNumbers.setText("Numeros originales: " + data.getNumbers().toString());
        sortedNumbers.setText("Numeros ordenados: " + data.getSortedNumbers().toString());

    }
}
