package com.example.ejercicio19;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.util.ArrayDeque;
import java.util.Deque;

public class HelloController {

    private Deque<String> undoStack = new ArrayDeque<>();
    private Deque<String> redoStack = new ArrayDeque<>();
    private String currentState = "";

    @FXML
    public TextArea taEditor;
    @FXML
    public Label lblStatus;

    @FXML
    public void saveChanges(ActionEvent actionEvent) {
        undoStack.push(currentState);
        currentState = taEditor.getText();

        redoStack.clear();

        lblStatus.setText("Estado actual: Cambios guardados");
    }

    @FXML
    public void undo(ActionEvent actionEvent) {
        if (!undoStack.isEmpty()) {
            redoStack.push(currentState);
            currentState = undoStack.pop();
            taEditor.setText(currentState);
            lblStatus.setText("Estado actual: Deshacer aplicado");
        } else {
            lblStatus.setText("Estado actual: Nada que deshacer");
        }
    }

    @FXML
    public void redo(ActionEvent actionEvent) {
        if (!redoStack.isEmpty()) {
            undoStack.push(currentState);
            currentState = redoStack.pop();
            taEditor.setText(currentState);
            lblStatus.setText("Estado actual: Rehacer aplicado");
        } else {
            lblStatus.setText("Estado actual: Nada que rehacer");
        }
    }
}