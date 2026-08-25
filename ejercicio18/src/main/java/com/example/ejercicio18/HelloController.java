package com.example.ejercicio18;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class HelloController {

    private Queue<String> clientsQueue = new ArrayDeque<>();
    private List<String> historyList = new ArrayList<>();
    private int turnNumber = 1;

    @FXML
    public TextField tfClientName;
    @FXML
    public Label lblStatus;
    @FXML
    public Label lblPendingClients;
    @FXML
    public Label lblHistory;

    @FXML
    public void registerClient(ActionEvent actionEvent) {
        String name = tfClientName.getText();
        if (!name.isEmpty()) {
            String clientTurn = "T-" + turnNumber + " (" + name + ")";
            clientsQueue.offer(clientTurn);
            turnNumber++;
            lblStatus.setText("Estado: Registrado " + clientTurn);
            updatePendingCount();
        } else {
            lblStatus.setText("Estado: Ingrese un nombre");
        }
        tfClientName.clear();
    }

    @FXML
    public void attendClient(ActionEvent actionEvent) {
        if (!clientsQueue.isEmpty()) {
            String attendedClient = clientsQueue.poll();
            historyList.add(attendedClient);
            lblStatus.setText("Estado: Atendiendo a " + attendedClient);
            updatePendingCount();
        } else {
            lblStatus.setText("Estado: No hay clientes pendientes");
        }
    }

    @FXML
    public void showHistory(ActionEvent actionEvent) {
        if (historyList.isEmpty()) {
            lblHistory.setText("Historial: Vacío");
        } else {
            lblHistory.setText("Historial: " + String.join(", ", historyList));
        }
    }

    private void updatePendingCount() {
        lblPendingClients.setText("Clientes pendientes: " + clientsQueue.size());
    }
}