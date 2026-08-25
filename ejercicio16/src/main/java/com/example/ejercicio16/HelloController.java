package com.example.ejercicio16;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {

    private ProductDAO productDAO = new ProductDAO();

    @FXML
    public TextField productName;
    @FXML
    public TextField productPrice;
    @FXML
    public TextField productQuantity;
    @FXML
    public TextField discountInput;

    @FXML
    public Label subtotalLabel;
    @FXML
    public Label discountLabel;
    @FXML
    public Label vatLabel;
    @FXML
    public Label totalLabel;

    @FXML
    public void registerProduct(ActionEvent actionEvent) {
        String name = productName.getText();
        double price = Double.parseDouble(productPrice.getText());
        int quantity = Integer.parseInt(productQuantity.getText());

        Product product = new Product(name, price, quantity);
        productDAO.addProduct(product);

        productName.clear();
        productPrice.clear();
        productQuantity.clear();
    }

    @FXML
    public void calculateTotals(ActionEvent actionEvent) {
        double subtotal = 0;

        for (Product p : productDAO.getProducts()) {
            subtotal += p.getPrice() * p.getQuantity();
        }

        double discountPercentage = 0;
        if (!discountInput.getText().isEmpty()) {
            discountPercentage = Double.parseDouble(discountInput.getText());
        }

        double discount = subtotal * (discountPercentage / 100);
        double subtotalWithDiscount = subtotal - discount;
        double vat = subtotalWithDiscount * 0.15;
        double total = subtotalWithDiscount + vat;

        subtotalLabel.setText("Subtotal: " + String.format("%.2f", subtotal));
        discountLabel.setText("Discount: " + String.format("%.2f", discount));
        vatLabel.setText("VAT (15%): " + String.format("%.2f", vat));
        totalLabel.setText("Total: " + String.format("%.2f", total));
    }
}