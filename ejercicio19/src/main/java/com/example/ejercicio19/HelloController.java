package com.example.ejercicio19;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void saveChanges(ActionEvent actionEvent) {
    }

    public void undo(ActionEvent actionEvent) {
    }

    public void redo(ActionEvent actionEvent) {
    }
}
