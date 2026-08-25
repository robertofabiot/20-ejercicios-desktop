package com.example.ejercicio14;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.ArrayDeque;
import java.util.Queue;

public class HelloController {

    private Queue<Integer> documentsQueue = new ArrayDeque<>();
    private int nextDocument = 1;

    @FXML
    public Label currentDocument;

    @FXML
    public Label pendingDocumentsCount;

    @FXML
    public void printDocument(ActionEvent actionEvent) {
        if (!documentsQueue.isEmpty()) {
            documentsQueue.poll();
        }
        updateUI();
    }

    @FXML
    public void addDocument(ActionEvent actionEvent) {
        documentsQueue.offer(nextDocument++);
        updateUI();
    }

    private void updateUI() {
        Integer current = documentsQueue.peek();
        if (current != null) {
            currentDocument.setText("Mostrar siguiente: " + current);
        } else {
            currentDocument.setText("Mostrar siguiente: Ninguno");
        }

        pendingDocumentsCount.setText("Documentos pendientes: " + documentsQueue.size());
    }
}