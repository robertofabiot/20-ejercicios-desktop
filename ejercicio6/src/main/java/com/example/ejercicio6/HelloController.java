package com.example.ejercicio6;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {

    ContactDao dao = new ContactDao();

    @FXML
    private TextField tfNameAdd;

    @FXML
    private TextField tfPhoneNumber;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfNameSearch;

    @FXML
    private Label lblPhone;

    @FXML
    private Label lblEmail;

    @FXML
    public void addContact(){
        String name = tfNameAdd.getText();
        String phoneNumber = tfPhoneNumber.getText();
        String email = tfEmail.getText();

        Contact newContact = new Contact(name, phoneNumber, email);
        dao.addContact(newContact);

        tfNameAdd.setText("");
        tfEmail.setText("");
        tfPhoneNumber.clear();
        tfNameSearch.setText("");
    }

    @FXML
    public void searchContact(){
        String name = tfNameSearch.getText();
        Contact contact = dao.searchContact(name);
        if(contact == null){
            lblPhone.setText("Teléfono: -");
            lblEmail.setText("Correo: -");
            return;
        }
        lblPhone.setText("Teléfono: " + contact.getPhoneNumber());
        lblEmail.setText("Correo: " + contact.getEmail());
    }

    @FXML
    public void deleteContact(){
        String name = tfNameSearch.getText();
        if (dao.deleteContact(name)) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Contacto Eliminado");
            alert.setHeaderText(null);
            alert.setContentText("El contacto '" + name + "' fue eliminado exitosamente.");
            tfNameSearch.clear();
            alert.showAndWait();

        } else {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Error al eliminar");
            errorAlert.setHeaderText(null);
            errorAlert.setContentText("No se pudo encontrar o eliminar el contacto.");

            errorAlert.showAndWait();
        }
    }
}
