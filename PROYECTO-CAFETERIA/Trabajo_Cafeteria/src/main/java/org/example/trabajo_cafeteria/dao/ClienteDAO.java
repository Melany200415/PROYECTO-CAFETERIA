package org.example.trabajo_cafeteria.dao;

import org.example.trabajo_cafeteria.modelo.Cliente;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    private List<Cliente> clientes = new ArrayList<>();

    public void agregar(Cliente cliente) {
        clientes.add(cliente);
    }

    public void eliminar(int id) {
        clientes.removeIf(c -> c.getId() == id);
    }

    public void actualizar(Cliente cliente) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getId() == cliente.getId()) {
                clientes.set(i, cliente);
                break;
            }
        }
    }

    public Cliente buscarPorId(int id) {
        for (Cliente c : clientes) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    public List<Cliente> listar() {
        return clientes;
    }
}
