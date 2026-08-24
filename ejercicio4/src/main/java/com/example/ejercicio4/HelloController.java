package com.example.ejercicio4;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {

    Data data = new Data();

    @FXML
    private TextField tfGrade;

    @FXML
    private Button btnAdd;

    @FXML
    private Label lblAvg;

    @FXML
    private Label lblHighestGrade;

    @FXML
    private Label lblLowestGrade;

    @FXML
    private Label lblPassingStudents;

    @FXML
    private Label lblFailingStudents;

    @FXML
    public void addGrade(){
        data.add(Double.parseDouble(tfGrade.getText()));
        lblAvg.setText("Promedio general: " + data.getAvg());
        lblHighestGrade.setText("Nota mayor: " + data.getHighestGrade());
        lblLowestGrade.setText("Nota mas baja: " + data.getLowesttGrade());
        lblPassingStudents.setText("Aprobados: " + data.getCountOfPassingStudents());
        lblFailingStudents.setText("Reprobados: " + data.getCountOfFailingStudents());
        tfGrade.setText("");
    }

}
