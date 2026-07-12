package org.example.trabajo_cafeteria.dao;

import org.example.trabajo_cafeteria.modelo.Producto;
import org.example.trabajo_cafeteria.util.Conexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {

    // GUARDAR
    public boolean guardar(Producto producto) {

        String sql = "INSERT INTO productos(nombre, descripcion, precio, stock) VALUES(?,?,?,?)";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getDescripcion());
            ps.setDouble(3, producto.getPrecio());
            ps.setInt(4, producto.getStock());

            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // LISTAR
    public List<Producto> listar() {

        List<Producto> lista = new ArrayList<>();

        String sql = "SELECT * FROM productos";

        try (Connection con = Conexion.getConexion()) {

            if (con == null) {
                System.out.println("La conexión es NULL");
                return lista;
            }

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                System.out.println("Leyendo: " + rs.getString("nombre"));

                Producto producto = new Producto();

                producto.setId(rs.getInt("id"));
                producto.setNombre(rs.getString("nombre"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setStock(rs.getInt("stock"));

                lista.add(producto);
            }

            System.out.println("Total productos: " + lista.size());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

    // ACTUALIZAR
    public boolean actualizar(Producto producto) {

        String sql = "UPDATE productos SET nombre=?, descripcion=?, precio=?, stock=? WHERE id=?";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getDescripcion());
            ps.setDouble(3, producto.getPrecio());
            ps.setInt(4, producto.getStock());
            ps.setInt(5, producto.getId());

            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // ELIMINAR
    public boolean eliminar(int id) {

        String sql = "DELETE FROM productos WHERE id=?";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // BUSCAR
    public Producto buscar(int id) {

        String sql = "SELECT * FROM productos WHERE id=?";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                return new Producto(

                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("descripcion"),
                        rs.getDouble("precio"),
                        rs.getInt("stock")

                );

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

}