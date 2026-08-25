package com.example.ejercicio6;

import java.util.ArrayList;
import java.util.List;

public class ProductDao {
    private final List<Product> productList = new ArrayList<>();

    public List<Product> getProductList() {
        return productList;
    }

    public void upsertProduct(Product product){
        Product productInList = searchProduct(product.getName());
        if(productInList == null){
            productList.add(product);
        }
        else {
            productInList.setStock(product.getStock());
            productInList.setPrice(product.getPrice());
        }
    }

    public Product searchProduct(String name){
        for(Product product : productList){
            if(product.getName().equals(name)){
                return product;
            }
        }
        return null;
    }

    public boolean deleteProduct(String name){
        for(Product product : productList){
            if(product.getName().equals(name)){
                return productList.remove(product);
            }
        }
        return false;
    }

    public Double getTotalValue(){
        double total = 0.0;
        for(Product product: productList){
            total += product.getPrice() * product.getStock();
        }
        return total;
    }
}
