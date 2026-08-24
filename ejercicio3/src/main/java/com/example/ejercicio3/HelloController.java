package com.example.ejercicio3;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
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
        tfNumber.setText("");

    }
}
