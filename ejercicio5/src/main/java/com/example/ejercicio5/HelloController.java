package com.example.ejercicio5;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class HelloController {

    Data data = new Data();

    @FXML
    private Label lblStudents;

    @FXML
    private TextField tfStudent;

    @FXML
    private Label lblResult;

    private void updateStudents(){
        lblStudents.setText(data.getStudents().toString());
    }

    @FXML
    public void add(){
        String student = tfStudent.getText();
        data.add(student);
        tfStudent.setText("");
        updateStudents();
        lblResult.setText("Estudiante " + student + " agregado.");
    }

    @FXML
    public void search(){
        String student = tfStudent.getText();
        List<Integer> positions = data.search(student);
        if(positions.isEmpty()){
            lblResult.setText("Estudiante no encontrado");
        } else {
            lblResult.setText("Estudiante encontrado en las posiciones " + positions.toString());
        }
        tfStudent.setText("");
    }

    @FXML
    public void delete(){
        String student = tfStudent.getText();
        if(data.delete(student)){
            lblResult.setText("Estudiante " + student + " eliminado");
        } else {
            lblResult.setText("Estudiante no encontrado.");
        }
        updateStudents();
    }

    @FXML
    public void getQuantity(){
        String student = tfStudent.getText();
        Integer quantity = data.getQuantity(student);
        lblResult.setText("Hay " +  quantity + "estudiantes");
    }


}
