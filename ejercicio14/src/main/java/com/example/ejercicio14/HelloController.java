package com.example.ejercicio14;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.ArrayDeque;
import java.util.Queue;

public class HelloController {

    private Queue<Integer> clientsQueue = new ArrayDeque<>();
    private int nextNumber = 1;

    @FXML
    public Label currentNumber;

    @FXML
    public Label pendingClientsCount;

    @FXML
    public void callNumber(ActionEvent actionEvent) {
        if (!clientsQueue.isEmpty()) {
            clientsQueue.poll(); // Remove the person who was just called
        }
        updateUI();
    }

    @FXML
    public void generateNumber(ActionEvent actionEvent) {
        // Use nextNumber++, so the first person gets 1, the next gets 2, etc.
        clientsQueue.offer(nextNumber++);
        updateUI();
    }

    // Consolidated method to update both labels safely
    private void updateUI() {
        // 1. Update the current turn label safely
        Integer current = clientsQueue.peek();
        if (current != null) {
            currentNumber.setText("Turno actual: " + current);
        } else {
            currentNumber.setText("Turno actual: Ninguno"); // or "Nadie en espera"
        }

        // 2. Update the pending clients count
        pendingClientsCount.setText("Clientes en espera: " + clientsQueue.size());
    }
}