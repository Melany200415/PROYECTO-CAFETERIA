package org.example.trabajo_cafeteria.controlador;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.example.trabajo_cafeteria.dao.ProductoDAO;
import org.example.trabajo_cafeteria.modelo.Producto;

public class ProductoController {

    @FXML
    private TextField txtNombre;

    @FXML
    private TextArea txtDescripcion;

    @FXML
    private TextField txtPrecio;

    @FXML
    private TextField txtStock;

    @FXML
    private TableView<Producto> tablaProductos;

    @FXML
    private TableColumn<Producto, Integer> colId;

    @FXML
    private TableColumn<Producto, String> colNombre;

    @FXML
    private TableColumn<Producto, String> colDescripcion;

    @FXML
    private TableColumn<Producto, Double> colPrecio;

    @FXML
    private TableColumn<Producto, Integer> colStock;

    private final ProductoDAO dao = new ProductoDAO();

    private final ObservableList<Producto> listaProductos =
            FXCollections.observableArrayList();

    @FXML
    private void leerProductos() {

        cargarTabla();

        mostrarMensaje("Productos cargados correctamente.");

    }
    @FXML
    public void initialize() {

        colId.setCellValueFactory(cellData ->
                new javafx.beans.property.SimpleIntegerProperty(cellData.getValue().getId()).asObject());

        colNombre.setCellValueFactory(cellData ->
                new javafx.beans.property.SimpleStringProperty(cellData.getValue().getNombre()));

        colDescripcion.setCellValueFactory(cellData ->
                new javafx.beans.property.SimpleStringProperty(cellData.getValue().getDescripcion()));

        colPrecio.setCellValueFactory(cellData ->
                new javafx.beans.property.SimpleDoubleProperty(cellData.getValue().getPrecio()).asObject());

        colStock.setCellValueFactory(cellData ->
                new javafx.beans.property.SimpleIntegerProperty(cellData.getValue().getStock()).asObject());

        cargarTabla();

        tablaProductos.getSelectionModel().selectedItemProperty().addListener(
                (observable, anterior, producto) -> {

                    if (producto != null) {

                        txtNombre.setText(producto.getNombre());
                        txtDescripcion.setText(producto.getDescripcion());
                        txtPrecio.setText(String.valueOf(producto.getPrecio()));
                        txtStock.setText(String.valueOf(producto.getStock()));

                    }

                });

    }
    @FXML
    private void guardarProducto() {

        if (camposVacios()) return;

        Producto producto = new Producto();

        producto.setNombre(txtNombre.getText());
        producto.setDescripcion(txtDescripcion.getText());
        producto.setPrecio(Double.parseDouble(txtPrecio.getText()));
        producto.setStock(Integer.parseInt(txtStock.getText()));

        if (dao.guardar(producto)) {

            mostrarMensaje("Producto guardado correctamente.");

            cargarTabla();

            limpiarCampos();

        }

    }

    @FXML
    private void actualizarProducto() {

        Producto seleccionado = tablaProductos.getSelectionModel().getSelectedItem();

        if (seleccionado == null) {

            mostrarMensaje("Seleccione un producto.");

            return;

        }

        seleccionado.setNombre(txtNombre.getText());
        seleccionado.setDescripcion(txtDescripcion.getText());
        seleccionado.setPrecio(Double.parseDouble(txtPrecio.getText()));
        seleccionado.setStock(Integer.parseInt(txtStock.getText()));

        if (dao.actualizar(seleccionado)) {

            mostrarMensaje("Producto actualizado.");

            cargarTabla();

            limpiarCampos();

        }

    }

    @FXML
    private void eliminarProducto() {

        Producto seleccionado = tablaProductos.getSelectionModel().getSelectedItem();

        if (seleccionado == null) {

            mostrarMensaje("Seleccione un producto.");

            return;

        }

        if (dao.eliminar(seleccionado.getId())) {

            mostrarMensaje("Producto eliminado.");

            cargarTabla();

            limpiarCampos();

        }

    }

    @FXML
    private void limpiarCampos() {

        txtNombre.clear();
        txtDescripcion.clear();
        txtPrecio.clear();
        txtStock.clear();

        tablaProductos.getSelectionModel().clearSelection();

    }

    @FXML
    private void salir() {

        System.exit(0);

    }

    private void cargarTabla() {

        listaProductos.setAll(dao.listar());

        tablaProductos.setItems(listaProductos);

    }

    private boolean camposVacios() {

        if (txtNombre.getText().isEmpty()
                || txtDescripcion.getText().isEmpty()
                || txtPrecio.getText().isEmpty()
                || txtStock.getText().isEmpty()) {

            mostrarMensaje("Complete todos los campos.");

            return true;

        }

        return false;

    }

    private void mostrarMensaje(String mensaje) {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setHeaderText(null);

        alert.setContentText(mensaje);

        alert.showAndWait();

    }

}