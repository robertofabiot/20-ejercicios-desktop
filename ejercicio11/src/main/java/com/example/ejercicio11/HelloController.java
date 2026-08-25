package com.example.ejercicio11;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Stack;

public class HelloController {

    Stack<Character> expresionStack = new Stack<>();

    @FXML
    public TextField expression;
    @FXML
    public Label result;

    @FXML
    public void initialize() {
        expression.textProperty().addListener((observable, oldValue, newValue) -> {
            if(areParenthesisBalanced(new ActionEvent())){
                result.setText("Resultado: Parentesis balanceados");
            } else{
                result.setText("Resultado: Parentesis no balanceados");
            }
        });
    }

    public boolean areParenthesisBalanced(ActionEvent actionEvent) {
        expresionStack.clear();
        int countOpening = 0;
        int countClosing = 0;
        for(int i = 0; i < expression.getText().length(); i++){
            char currentCharacter = expression.getText().charAt(i);

            if((currentCharacter == '(' && i == expression.getLength()-1) || (currentCharacter == ')' && i == 0)) return false;

            if(currentCharacter == '('){
                expresionStack.push(currentCharacter);
                countOpening++;
            }
            if(currentCharacter == ')'){
                expresionStack.push(currentCharacter);
                countClosing++;
            }
        }
        return countClosing == countOpening;
    }
}