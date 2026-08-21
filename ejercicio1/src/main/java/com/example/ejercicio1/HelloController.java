package com.example.ejercicio1;

import com.example.ejercicio1.utils.Data;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {

    Data data = new Data();

    @FXML
    private TextField txtNumber;

    @FXML
    private Button btnAdd;

    @FXML
    private Label lblMax;

    @FXML
    private Label lblMin;

    @FXML
    private Label lblAvg;

    @FXML
    private Label lblSum;

    @FXML
    private Label lblEven;

    @FXML
    private Label lblOdd;

    @FXML
    private void onAddButtonClick(){
        data.add(Integer.parseInt(txtNumber.getText()));
        lblMax.setText("Mayor: " + data.getMax());
        lblMin.setText("Menor: " + data.getMin());
        lblAvg.setText("Promedio: " + data.getAvg());
        lblSum.setText("Suma: " + data.getSum());
        lblEven.setText("Pares: " + data.getEvenNumbersCount());
        lblOdd.setText("Impares: " + data.getOddNumbersCount());
    }
}
