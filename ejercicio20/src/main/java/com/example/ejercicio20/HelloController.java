package com.example.ejercicio20;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    private InventarioDAO inventarioDAO = new InventarioDAO();

    @FXML
    public TextField tfCodigo;
    @FXML
    public TextField tfNombre;
    @FXML
    public ChoiceBox<String> cbCategoria;
    @FXML
    public TextField tfPrecio;
    @FXML
    public TextField tfCantidad;

    @FXML
    public TextField tfCliente;
    @FXML
    public TextField tfCodigoPedido;
    @FXML
    public TextField tfCantidadPedido;

    @FXML
    public ListView<String> lvInventario;
    @FXML
    public ListView<String> lvPedidos;

    @FXML
    public Label lblEstado;
    @FXML
    public Label lblTotales;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cbCategoria.setItems(FXCollections.observableArrayList(inventarioDAO.getCategorias()));
        cbCategoria.setValue(inventarioDAO.getCategorias()[0]);
        actualizarVistas();
    }

    @FXML
    public void registrarProducto(ActionEvent actionEvent) {
        try {
            inventarioDAO.registrarProducto(
                    tfCodigo.getText().trim(),
                    tfNombre.getText().trim(),
                    cbCategoria.getValue(),
                    tfPrecio.getText().trim(),
                    tfCantidad.getText().trim());

            lblEstado.setText("Estado: Producto registrado");
            limpiarCamposProducto();
            actualizarVistas();
        } catch (ValidacionException e) {
            lblEstado.setText("Estado: " + e.getMessage());
        }
    }

    @FXML
    public void buscarProducto(ActionEvent actionEvent) {
        Producto producto = inventarioDAO.buscarProducto(tfCodigo.getText().trim());
        if (producto == null) {
            lblEstado.setText("Estado: Producto no encontrado");
        } else {
            lblEstado.setText("Estado: " + producto + " | Precio: "
                    + String.format("%.2f", producto.getPrecio()));
        }
    }

    @FXML
    public void registrarPedido(ActionEvent actionEvent) {
        try {
            Pedido pedido = inventarioDAO.registrarPedido(
                    tfCliente.getText().trim(),
                    tfCodigoPedido.getText().trim(),
                    tfCantidadPedido.getText().trim());

            lblEstado.setText("Estado: Pedido " + pedido.getNumero() + " en cola");
            limpiarCamposPedido();
            actualizarVistas();
        } catch (ValidacionException e) {
            lblEstado.setText("Estado: " + e.getMessage());
        }
    }

    @FXML
    public void despacharPedido(ActionEvent actionEvent) {
        try {
            Pedido pedido = inventarioDAO.despacharPedido();
            lblEstado.setText("Estado: Despachado " + pedido.getNumero()
                    + " para " + pedido.getCliente());
            actualizarVistas();
        } catch (ValidacionException e) {
            lblEstado.setText("Estado: " + e.getMessage());
        }
    }

    @FXML
    public void deshacerOperacion(ActionEvent actionEvent) {
        try {
            String mensaje = inventarioDAO.deshacerUltimaOperacion();
            lblEstado.setText("Estado: " + mensaje);
            actualizarVistas();
        } catch (ValidacionException e) {
            lblEstado.setText("Estado: " + e.getMessage());
        }
    }

    private void limpiarCamposProducto() {
        tfCodigo.clear();
        tfNombre.clear();
        tfPrecio.clear();
        tfCantidad.clear();
    }

    private void limpiarCamposPedido() {
        tfCliente.clear();
        tfCodigoPedido.clear();
        tfCantidadPedido.clear();
    }

    private void actualizarVistas() {
        lvInventario.getItems().clear();
        for (Producto p : inventarioDAO.getProductos()) {
            lvInventario.getItems().add(p + " | Subtotal: " + String.format("%.2f", p.getSubtotal()));
        }

        lvPedidos.getItems().clear();
        for (Pedido pedido : inventarioDAO.getPedidosPendientes()) {
            lvPedidos.getItems().add(pedido.toString());
        }

        lblTotales.setText("Productos: " + inventarioDAO.getProductos().size()
                + " | Pedidos en cola: " + inventarioDAO.getPedidosPendientes().size()
                + " | Operaciones en pila: " + inventarioDAO.getHistorialOperaciones().size()
                + " | Valor inventario: " + String.format("%.2f", inventarioDAO.calcularValorInventario()));
    }
}
