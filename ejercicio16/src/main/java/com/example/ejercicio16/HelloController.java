package com.example.ejercicio14;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

public class HelloController {

    private List<String> products = new ArrayList<>();
    private List<Double> prices = new ArrayList<>();
    private List<Integer> quantities = new ArrayList<>();

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
    public Label ivaLabel;
    @FXML
    public Label totalLabel;

    @FXML
    public void registerProduct(ActionEvent actionEvent) {
        products.add(productName.getText());
        prices.add(Double.parseDouble(productPrice.getText()));
        quantities.add(Integer.parseInt(productQuantity.getText()));

        productName.clear();
        productPrice.clear();
        productQuantity.clear();
    }

    @FXML
    public void calculateTotals(ActionEvent actionEvent) {
        double subtotal = 0;

        for (int i = 0; i < products.size(); i++) {
            subtotal += prices.get(i) * quantities.get(i);
        }

        double discountPercentage = 0;
        if (!discountInput.getText().isEmpty()) {
            discountPercentage = Double.parseDouble(discountInput.getText());
        }

        double discount = subtotal * (discountPercentage / 100);
        double subtotalWithDiscount = subtotal - discount;
        double iva = subtotalWithDiscount * 0.15;
        double total = subtotalWithDiscount + iva;

        subtotalLabel.setText("Subtotal: " + String.format("%.2f", subtotal));
        discountLabel.setText("Descuento: " + String.format("%.2f", discount));
        ivaLabel.setText("IVA (15%): " + String.format("%.2f", iva));
        totalLabel.setText("Total: " + String.format("%.2f", total));
    }
}