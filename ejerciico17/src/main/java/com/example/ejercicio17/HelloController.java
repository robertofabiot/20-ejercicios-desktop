package com.example.ejercicio17;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

public class HelloController {

    private List<String> bookTitles = new ArrayList<>();
    private List<Boolean> bookAvailability = new ArrayList<>();

    @FXML
    public TextField tfBookTitle;
    @FXML
    public Label lblStatus;
    @FXML
    public Label lblAvailableBooks;

    @FXML
    public void registerBook(ActionEvent actionEvent) {
        String title = tfBookTitle.getText();
        if (!title.isEmpty() && !bookTitles.contains(title)) {
            bookTitles.add(title);
            bookAvailability.add(true);
            lblStatus.setText("Estado: Libro registrado");
            updateAvailableCount();
        } else {
            lblStatus.setText("Estado: El libro ya existe o el campo está vacío");
        }
        tfBookTitle.clear();
    }

    @FXML
    public void searchBook(ActionEvent actionEvent) {
        String title = tfBookTitle.getText();
        int index = bookTitles.indexOf(title);
        if (index != -1) {
            boolean isAvailable = bookAvailability.get(index);
            String availabilityText = isAvailable ? "Disponible" : "Prestado";
            lblStatus.setText("Estado: Encontrado - " + availabilityText);
        } else {
            lblStatus.setText("Estado: Libro no encontrado");
        }
    }

    @FXML
    public void borrowBook(ActionEvent actionEvent) {
        String title = tfBookTitle.getText();
        int index = bookTitles.indexOf(title);
        if (index != -1) {
            if (bookAvailability.get(index)) {
                bookAvailability.set(index, false);
                lblStatus.setText("Estado: Libro prestado exitosamente");
                updateAvailableCount();
            } else {
                lblStatus.setText("Estado: El libro ya está prestado");
            }
        } else {
            lblStatus.setText("Estado: Libro no encontrado");
        }
        tfBookTitle.clear();
    }

    @FXML
    public void returnBook(ActionEvent actionEvent) {
        String title = tfBookTitle.getText();
        int index = bookTitles.indexOf(title);
        if (index != -1) {
            if (!bookAvailability.get(index)) {
                bookAvailability.set(index, true);
                lblStatus.setText("Estado: Libro devuelto exitosamente");
                updateAvailableCount();
            } else {
                lblStatus.setText("Estado: El libro ya estaba disponible");
            }
        } else {
            lblStatus.setText("Estado: Libro no encontrado");
        }
        tfBookTitle.clear();
    }

    private void updateAvailableCount() {
        int count = 0;
        for (Boolean available : bookAvailability) {
            if (available) {
                count++;
            }
        }
        lblAvailableBooks.setText("Libros disponibles: " + count);
    }
}