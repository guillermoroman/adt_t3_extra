package dao;

import modelo.Producto;
import baseDatos.ConexionBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAOImpl implements ProductoDAO {

    @Override
    public int agregar(Producto producto) throws SQLException {
        String sql = "INSERT INTO productos (nombre, precio, id_proveedor) VALUES (?, ?, ?)";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, producto.getNombre());
            pstmt.setDouble(2, producto.getPrecio());
            pstmt.setInt(3, producto.getIdProveedor());

            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        return generatedKeys.getInt(1);
                    }
                }
            }
            return -1;
        }
    }

    @Override
    public Producto obtenerPorId(int id) throws SQLException {
        String sql = "SELECT * FROM productos WHERE id = ?";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return new Producto(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getDouble("precio"),
                        rs.getInt("id_proveedor")
                );
            } else {
                return null;
            }
        }
    }

    @Override
    public List<Producto> obtenerTodos() throws SQLException {
        List<Producto> productos = new ArrayList<>();
        String sql = "SELECT * FROM productos";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                productos.add(new Producto(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getDouble("precio"),
                        rs.getInt("id_proveedor")
                ));
            }
        }
        return productos;
    }

    @Override
    public boolean actualizar(Producto producto) throws SQLException {
        String sql = "UPDATE productos SET nombre = ?, precio = ?, id_proveedor = ? WHERE id = ?";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, producto.getNombre());
            pstmt.setDouble(2, producto.getPrecio());
            pstmt.setInt(3, producto.getIdProveedor());
            pstmt.setInt(4, producto.getId());

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        }
    }

    @Override
    public boolean eliminar(int id) throws SQLException {
        String sql = "DELETE FROM productos WHERE id = ?";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        }
    }

    public List<ProductoConProveedor> obtenerProductosConProveedor() throws SQLException {
        List<ProductoConProveedor> productosConProveedores = new ArrayList<>();
        String sql = "SELECT p.id, p.nombre, p.precio, pr.nombre as nombreProveedor " +
                "FROM productos p INNER JOIN proveedores pr ON p.id_proveedor = pr.id";

        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                ProductoConProveedor productoConProveedor = new ProductoConProveedor(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getDouble("precio"),
                        rs.getString("nombreProveedor")
                );
                productosConProveedores.add(productoConProveedor);
            }
        }
        return productosConProveedores;
    }

    // Clase interna para representar un Producto con su Proveedor
    public static class ProductoConProveedor {
        private int idProducto;
        private String nombreProducto;
        private double precio;
        private String nombreProveedor;

        public ProductoConProveedor(int idProducto, String nombreProducto, double precio, String nombreProveedor) {
            this.idProducto = idProducto;
            this.nombreProducto = nombreProducto;
            this.precio = precio;
            this.nombreProveedor = nombreProveedor;
        }

        @Override
        public String toString() {
            return "Producto{" +
                    "ID=" + idProducto +
                    ", Nombre='" + nombreProducto + '\'' +
                    ", Precio=" + precio +
                    ", Proveedor='" + nombreProveedor + '\'' +
                    '}';
        }
    }
}
