package com.example.ejercicio13;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayDeque;
import java.util.Queue;

public class HelloController {

    Queue<String> clientsQueue = new ArrayDeque<>();

    public TextField tfNewClient;
    public Label lblNextClient;
    public Label lblPendingClients;

    public void addClient(ActionEvent actionEvent) {
        clientsQueue.offer(tfNewClient.getText());
        updateNextClient();
        updatePendingClients();
    }

    public void serveClient(ActionEvent actionEvent) {
        clientsQueue.poll();
        updateNextClient();
        updatePendingClients();
    }

    private void updateNextClient(){
        lblNextClient.setText("Siguiente cliente: " + (clientsQueue.peek() == null ? "" : clientsQueue.peek() ));
    }

    private void updatePendingClients(){
        lblPendingClients.setText("Clientes pendientes: " + clientsQueue.size());
    }
}
