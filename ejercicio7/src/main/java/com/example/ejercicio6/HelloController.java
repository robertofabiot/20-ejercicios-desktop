package com.example.ejercicio6;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {

    ProductDao dao = new ProductDao();

    @FXML
    private TextField tfNameAdd;

    @FXML
    private TextField tfQuantity;

    @FXML
    private TextField tfPrice;

    @FXML
    private TextField tfNameSearch;

    @FXML
    private Label lblQuantity;

    @FXML
    private Label lblPrice;

    @FXML
    private Label lblTotalValue;

    @FXML
    public void upsertProduct(){
        String name = tfNameAdd.getText();
        Integer quantity = Integer.parseInt(tfQuantity.getText());
        Double price = Double.parseDouble(tfPrice.getText());

        Product newProduct = new Product(quantity, price, name);
        dao.upsertProduct(newProduct);

        tfNameAdd.setText("");
        tfQuantity.setText("");
        tfPrice.clear();
        tfNameSearch.setText("");
        updateTotalValue();
    }

    @FXML
    public void searchProduct(){
        String name = tfNameSearch.getText();
        Product product = dao.searchProduct(name);
        if(product == null){
            lblQuantity.setText("Cantidad: -");
            lblPrice.setText("Precio: -");
            return;
        }
        lblQuantity.setText("Cantidad: " + product.getStock());
        lblPrice.setText("Precio: " + product.getPrice());
    }

    @FXML
    public void deleteProduct(){
        String name = tfNameSearch.getText();
        if (dao.deleteProduct(name)) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Producto Eliminado");
            alert.setHeaderText(null);
            alert.setContentText("El producto '" + name + "' fue eliminado exitosamente.");
            tfNameSearch.clear();
            alert.showAndWait();

        } else {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Error al eliminar");
            errorAlert.setHeaderText(null);
            errorAlert.setContentText("No se pudo encontrar o eliminar el producto.");

            errorAlert.showAndWait();
        }
        updateTotalValue();
    }

    @FXML
    private void updateTotalValue(){
        lblTotalValue.setText("Valor totaL: " + dao.getTotalValue());
    }
}
