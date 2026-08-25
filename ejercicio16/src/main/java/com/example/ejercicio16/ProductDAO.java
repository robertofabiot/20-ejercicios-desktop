package com.example.ejercicio16;

import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    private final List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }
}