package com.example.ejercicio20;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Queue;

public class InventarioDAO {

    // Arreglo: categorias fijas del sistema
    private static final String[] CATEGORIAS = {"Bebidas", "Alimentos", "Limpieza", "Electronica"};

    // ArrayList: inventario de productos
    private List<Producto> productos = new ArrayList<>();

    // Cola: pedidos pendientes de despachar
    private Queue<Pedido> pedidosPendientes = new ArrayDeque<>();

    // Pila: historial de operaciones para deshacer
    private Deque<String> historialOperaciones = new ArrayDeque<>();

    private int contadorPedidos = 1;

    public String[] getCategorias() {
        return CATEGORIAS;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public Queue<Pedido> getPedidosPendientes() {
        return pedidosPendientes;
    }

    public Deque<String> getHistorialOperaciones() {
        return historialOperaciones;
    }

    public Producto buscarProducto(String codigo) {
        for (Producto p : productos) {
            if (p.getCodigo().equalsIgnoreCase(codigo)) {
                return p;
            }
        }
        return null;
    }

    public boolean categoriaValida(String categoria) {
        for (String c : CATEGORIAS) {
            if (c.equals(categoria)) {
                return true;
            }
        }
        return false;
    }

    public void registrarProducto(String codigo, String nombre, String categoria,
                                  String precioTexto, String cantidadTexto) throws ValidacionException {
        if (codigo.isEmpty() || nombre.isEmpty()) {
            throw new ValidacionException("El codigo y el nombre son obligatorios");
        }
        if (!categoriaValida(categoria)) {
            throw new ValidacionException("Seleccione una categoria valida");
        }
        if (buscarProducto(codigo) != null) {
            throw new ValidacionException("Ya existe un producto con el codigo " + codigo);
        }

        double precio;
        int cantidad;
        try {
            precio = Double.parseDouble(precioTexto);
            cantidad = Integer.parseInt(cantidadTexto);
        } catch (NumberFormatException e) {
            throw new ValidacionException("El precio y la cantidad deben ser numericos");
        }

        if (precio <= 0) {
            throw new ValidacionException("El precio debe ser mayor que cero");
        }
        if (cantidad < 0) {
            throw new ValidacionException("La cantidad no puede ser negativa");
        }

        productos.add(new Producto(codigo, nombre, categoria, precio, cantidad));
        historialOperaciones.push("ALTA:" + codigo);
    }

    public Pedido registrarPedido(String cliente, String codigo, String cantidadTexto) throws ValidacionException {
        if (cliente.isEmpty()) {
            throw new ValidacionException("El nombre del cliente es obligatorio");
        }

        Producto producto = buscarProducto(codigo);
        if (producto == null) {
            throw new ValidacionException("No existe un producto con el codigo " + codigo);
        }

        int cantidad;
        try {
            cantidad = Integer.parseInt(cantidadTexto);
        } catch (NumberFormatException e) {
            throw new ValidacionException("La cantidad debe ser numerica");
        }

        if (cantidad <= 0) {
            throw new ValidacionException("La cantidad debe ser mayor que cero");
        }
        if (cantidad > producto.getCantidad()) {
            throw new ValidacionException("Stock insuficiente. Disponible: " + producto.getCantidad());
        }

        Pedido pedido = new Pedido("P-" + contadorPedidos, cliente, producto.getCodigo(), cantidad);
        contadorPedidos++;
        pedidosPendientes.offer(pedido);
        return pedido;
    }

    public Pedido despacharPedido() throws ValidacionException {
        if (pedidosPendientes.isEmpty()) {
            throw new ValidacionException("No hay pedidos pendientes");
        }

        Pedido pedido = pedidosPendientes.poll();
        Producto producto = buscarProducto(pedido.getCodigoProducto());

        if (producto == null) {
            throw new ValidacionException("El producto del pedido ya no existe");
        }
        if (pedido.getCantidad() > producto.getCantidad()) {
            throw new ValidacionException("Stock insuficiente para despachar " + pedido.getNumero());
        }

        producto.setCantidad(producto.getCantidad() - pedido.getCantidad());
        historialOperaciones.push("DESPACHO:" + pedido.getNumero() + ":" + pedido.getCodigoProducto()
                + ":" + pedido.getCantidad());
        return pedido;
    }

    public String deshacerUltimaOperacion() throws ValidacionException {
        if (historialOperaciones.isEmpty()) {
            throw new ValidacionException("No hay operaciones que deshacer");
        }

        String operacion = historialOperaciones.pop();
        String[] partes = operacion.split(":");

        if (partes[0].equals("ALTA")) {
            Producto producto = buscarProducto(partes[1]);
            if (producto != null) {
                productos.remove(producto);
            }
            return "Se elimino el producto " + partes[1];
        }

        // DESPACHO: se devuelve el stock descontado
        Producto producto = buscarProducto(partes[2]);
        if (producto != null) {
            producto.setCantidad(producto.getCantidad() + Integer.parseInt(partes[3]));
        }
        return "Se revirtio el despacho " + partes[1];
    }

    public double calcularValorInventario() {
        double total = 0;
        for (Producto p : productos) {
            total += p.getSubtotal();
        }
        return total;
    }
}
