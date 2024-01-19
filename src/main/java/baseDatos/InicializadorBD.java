package baseDatos;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

public class InicializadorBD {

    public static void crearTablas() {
        String sqlCrearTablaProductos =
                "CREATE TABLE IF NOT EXISTS productos (" +
                        "id INT AUTO_INCREMENT PRIMARY KEY," +
                        "nombre VARCHAR(255) NOT NULL," +
                        "precio DECIMAL(10, 2) NOT NULL," +
                        "id_proveedor INT," +
                        "FOREIGN KEY (id_proveedor) REFERENCES proveedores(id)" +
                        ");";

        String sqlCrearTablaProveedores =
                "CREATE TABLE IF NOT EXISTS proveedores (" +
                        "id INT AUTO_INCREMENT PRIMARY KEY," +
                        "nombre VARCHAR(255) NOT NULL," +
                        "direccion VARCHAR(255)," +
                        "email VARCHAR(255)" +
                        ");";

        try (Connection conn = ConexionBD.obtenerConexion();
             Statement stmt = conn.createStatement()) {
            // Crear tabla proveedores primero debido a la clave foránea en productos
            stmt.execute(sqlCrearTablaProveedores);
            stmt.execute(sqlCrearTablaProductos);
            System.out.println("Tablas creadas con éxito.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void poblarTablas() {
        // Ejemplo de inserción de datos en las tablas
        String sqlInsertarProveedores =
                "INSERT INTO proveedores (nombre, direccion, email) VALUES " +
                        "('Proveedor A', 'Dirección A', 'email@a.com')," +
                        "('Proveedor B', 'Dirección B', 'email@b.com');";

        String sqlInsertarProductos =
                "INSERT INTO productos (nombre, precio, id_proveedor) VALUES " +
                        "('Producto 1', 10.50, 1)," +
                        "('Producto 2', 15.75, 2);";

        try (Connection conn = ConexionBD.obtenerConexion();
             Statement stmt = conn.createStatement()) {
            // Insertar proveedores
            stmt.execute(sqlInsertarProveedores);
            // Insertar productos
            stmt.execute(sqlInsertarProductos);
            System.out.println("Datos iniciales insertados con éxito.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
