package org.example.trabajo_cafeteria.dao;

import org.example.trabajo_cafeteria.modelo.Usuario;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    private List<Usuario> usuarios = new ArrayList<>();

    public void agregar(Usuario usuario) {
        usuarios.add(usuario);
    }

    public void eliminar(int id) {
        usuarios.removeIf(u -> u.getId() == id);
    }

    public void actualizar(Usuario usuario) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getId() == usuario.getId()) {
                usuarios.set(i, usuario);
                break;
            }
        }
    }

    public Usuario buscarPorId(int id) {
        for (Usuario u : usuarios) {
            if (u.getId() == id) {
                return u;
            }
        }
        return null;
    }

    public Usuario login(String usuario, String contrasena) {
        for (Usuario u : usuarios) {
            if (u.getUsuario().equals(usuario) && u.getContrasena().equals(contrasena)) {
                return u;
            }
        }
        return null;
    }

    public List<Usuario> listar() {
        return usuarios;
    }
}
