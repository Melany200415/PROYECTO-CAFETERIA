package org.example.trabajo_cafeteria.dao;

import org.example.trabajo_cafeteria.modelo.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    private List<Cliente> clientes = new ArrayList<>();

    public void agregar(Cliente cliente) {
        clientes.add(cliente);
    }

    public void eliminar(String cedula) {
        clientes.removeIf(c -> c.getCedula().equals(cedula));
    }

    public void actualizar(Cliente cliente) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getCedula().equals(cliente.getCedula())) {
                clientes.set(i, cliente);
                break;
            }
        }
    }

    public Cliente buscarPorCedula(String cedula) {
        for (Cliente c : clientes) {
            if (c.getCedula().equals(cedula)) {
                return c;
            }
        }
        return null;
    }

    public List<Cliente> listar() {
        return clientes;
    }
}