package com.example.ejercicio2;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {

    Data data = new Data();

    @FXML
    private TextField tfAddNumber;

    @FXML
    private Button btnAdd;

    @FXML
    private TextField tfSearch;

    @FXML
    private Button btnSearch;

    @FXML
    private Label exists;

    @FXML
    private Label position;

    @FXML
    private Label count;

    public void addNumber(){
        int number = Integer.parseInt(tfAddNumber.getText());
        data.add(number);
        tfAddNumber.setText("");
    }

    public void searchNumber(){
        int number = Integer.parseInt(tfSearch.getText());
        exists.setText("Existe: " + ((data.numberExists(number)) ? "Si" : "No"));
        position.setText("Posicion: " + ((data.getPositionsOf(number) == null) ? "Ninguna" : ((data.getPositionsOf(number).toString()))));
        count.setText("Veces que aparece: " + data.appeearingTimes(number));
    }
}
