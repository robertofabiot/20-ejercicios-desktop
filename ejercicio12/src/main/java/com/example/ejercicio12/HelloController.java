package com.example.ejercicio12;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.List;
import java.util.Stack;

public class HelloController {
    public TextField tfText;
    public Label lblInvertedText;

    public void invert(ActionEvent actionEvent) {
        Stack<Character> stack = new Stack<>();
        String currentText = tfText.getText();
        for(int i = 0; i < currentText.length(); i++){
            stack.push(currentText.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < currentText.length(); i++){
            sb.append(stack.pop());
        }
        lblInvertedText.setText(sb.toString());
    }
}
