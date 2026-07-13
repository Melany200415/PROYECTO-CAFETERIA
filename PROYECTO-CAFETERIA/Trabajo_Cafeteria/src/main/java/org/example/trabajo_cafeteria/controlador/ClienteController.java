package org.example.trabajo_cafeteria.controlador;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.example.trabajo_cafeteria.modelo.Cliente;

public class ClienteController {


    //separacion de realizacion, hecho por esteban
    @FXML
    private TextField txtCedula;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtTelefono;

    @FXML
    private TextField txtCorreo;

    @FXML
    private TableView<Cliente> tablaClientes;

    @FXML
    private TableColumn<Cliente, String> colCedula;

    @FXML
    private TableColumn<Cliente, String> colNombre;

    @FXML
    private TableColumn<Cliente, String> colTelefono;

    @FXML
    private TableColumn<Cliente, String> colCorreo;

    private final ObservableList<Cliente> listaClientes =
            FXCollections.observableArrayList();


    //separacion de realizacion, hecho por esteban
    @FXML
    public void initialize() {
        colCedula.setCellValueFactory(cellData ->
                new javafx.beans.property.SimpleStringProperty(
                        cellData.getValue().getCedula()));

        colNombre.setCellValueFactory(cellData ->
                new javafx.beans.property.SimpleStringProperty(
                        cellData.getValue().getNombre()));

        colTelefono.setCellValueFactory(cellData ->
                new javafx.beans.property.SimpleStringProperty(
                        cellData.getValue().getTelefono()));

        colCorreo.setCellValueFactory(cellData ->
                new javafx.beans.property.SimpleStringProperty(
                        cellData.getValue().getCorreo()));

        tablaClientes.setItems(listaClientes);

        tablaClientes.getSelectionModel().selectedItemProperty().addListener(
                (observable, anterior, cliente) -> {

                    if (cliente != null) {

                        txtCedula.setText(cliente.getCedula());
                        txtNombre.setText(cliente.getNombre());
                        txtTelefono.setText(cliente.getTelefono());
                        txtCorreo.setText(cliente.getCorreo());

                    }

                });
    }

    //separacion de realizacion, hecho por esteban
    @FXML
    private void guardarCliente() {
        if (txtCedula.getText().isEmpty() ||
                txtNombre.getText().isEmpty() ||
                txtTelefono.getText().isEmpty() ||
                txtCorreo.getText().isEmpty()) {

            mostrarMensaje("Complete todos los campos.");
            return;
        }

        Cliente cliente = new Cliente();

        cliente.setCedula(txtCedula.getText());
        cliente.setNombre(txtNombre.getText());
        cliente.setTelefono(txtTelefono.getText());
        cliente.setCorreo(txtCorreo.getText());

        listaClientes.add(cliente);

        limpiarCampos();

        mostrarMensaje("Cliente guardado correctamente.");

    }

    @FXML
    private void crearCliente() {
        limpiarCampos();
    }

    //separacion de realizacion, hecho por esteban
    @FXML
    private void actualizarCliente() {
        Cliente cliente = tablaClientes.getSelectionModel().getSelectedItem();

        if (cliente == null) {

            mostrarMensaje("Seleccione un cliente.");

            return;

        }

        cliente.setCedula(txtCedula.getText());
        cliente.setNombre(txtNombre.getText());
        cliente.setTelefono(txtTelefono.getText());
        cliente.setCorreo(txtCorreo.getText());

        tablaClientes.refresh();
        limpiarCampos();
        mostrarMensaje("Cliente actualizado.");
    }


    //separacion de realizacion, hecho por esteban
    @FXML
    private void eliminarCliente() {
        Cliente cliente = tablaClientes.getSelectionModel().getSelectedItem();

        if (cliente == null) {

            mostrarMensaje("Seleccione un cliente.");

            return;

        }
        listaClientes.remove(cliente);
        limpiarCampos();
        mostrarMensaje("Cliente eliminado.");
    }

    //separacion de realizacion, hecho por esteban
    @FXML
    private void limpiarCampos() {

        txtCedula.clear();
        txtNombre.clear();
        txtTelefono.clear();
        txtCorreo.clear();

        tablaClientes.getSelectionModel().clearSelection();

    }

    //separacion de realizacion, hecho por esteban
    @FXML
    private void salir() {
        System.exit(0);
    }

    private void mostrarMensaje(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

}