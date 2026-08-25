package com.example.ejercicio10;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.Stack;

public class HelloController {

    Stack<String> stack = new Stack<>();

    public Label lblResult;
    public Label lblCurrentOperation;

    public void hackNasa(ActionEvent actionEvent) {
        lblResult.setText("Ultima accion hecha: NASA hackeada.");
        stack.push("NASA hackeada");
        updateCurrentOperation();
    }

    public void enterDarkWek(ActionEvent actionEvent) {
        lblResult.setText("Ultima accion hecha: Dark Web visitada");
        stack.push("Dark Web visitada");
        updateCurrentOperation();
    }

    public void fuckMicrosoft(ActionEvent actionEvent) {
        lblResult.setText("Lo siento, eso está fuera de las capacidades de cualquier hacker.");
    }

    public void undo(ActionEvent actionEvent) {
        lblResult.setText("Ultima accion hecha: deshacer operacion " + stack.pop());
        updateCurrentOperation();
    }

    public void updateCurrentOperation(){
        lblCurrentOperation.setText("Operacion actual: " + stack.peek());
    }
}
