package com.example.ejercicio11;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Stack;

public class HelloController {

    Stack<String> expresionStack = new Stack<>();

    public TextField expresion;
    public Label result;
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void evaluateParenthesis(ActionEvent actionEvent) {
    }
}
