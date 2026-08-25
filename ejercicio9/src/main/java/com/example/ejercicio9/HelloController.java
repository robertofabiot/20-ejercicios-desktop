package com.example.ejercicio9;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Stack;

public class HelloController {

    Stack<String> stack = new Stack<String>();

    public TextField tfElement;
    public Label lblResult;
    public Label lblStack;
    public Label lblIsEmpty;

    public void push(ActionEvent actionEvent) {
        String element = tfElement.getText();
        stack.push(element);
        lblResult.setText(element + " aǹadido a la cola");
        updateLblStack();
        updateLblIsEmpty();
    }

    public void pop(ActionEvent actionEvent) {
        String poppedElement = stack.pop();
        lblResult.setText(poppedElement + " eliminado de la cola");
        updateLblStack();
        updateLblIsEmpty();
    }

    public void peek(ActionEvent actionEvent) {
        String peekedElement = stack.peek();
        lblResult.setText("El elemento en peek es " + peekedElement);
    }

    private void updateLblStack(){
        lblStack.setText(stack.toString());
    }

    private void updateLblIsEmpty(){
        if ((stack.isEmpty())) {
            lblIsEmpty.setText("La pila está vacía");
        } else {
            lblIsEmpty.setText("La pila no está vacía.");
        }
    }
}
