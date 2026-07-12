package org.example.trabajo_cafeteria.dao;

import org.example.trabajo_cafeteria.modelo.Producto;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {

    private List<Producto> productos = new ArrayList<>();

    public void agregar(Producto producto) {
        productos.add(producto);
    }

    public void eliminar(int id) {
        productos.removeIf(p -> p.getId() == id);
    }

    public void actualizar(Producto producto) {
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getId() == producto.getId()) {
                productos.set(i, producto);
                break;
            }
        }
    }

    public Producto buscarPorId(int id) {
        for (Producto p : productos) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public List<Producto> listar() {
        return productos;
    }
}
