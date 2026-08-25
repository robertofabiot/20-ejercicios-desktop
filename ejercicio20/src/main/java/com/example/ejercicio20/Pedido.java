package com.example.ejercicio20;

public class Pedido {

    private String numero;
    private String cliente;
    private String codigoProducto;
    private int cantidad;

    public Pedido(String numero, String cliente, String codigoProducto, int cantidad) {
        this.numero = numero;
        this.cliente = cliente;
        this.codigoProducto = codigoProducto;
        this.cantidad = cantidad;
    }

    public String getNumero() {
        return numero;
    }

    public String getCliente() {
        return cliente;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    @Override
    public String toString() {
        return numero + " | " + cliente + " -> " + codigoProducto + " x" + cantidad;
    }
}
