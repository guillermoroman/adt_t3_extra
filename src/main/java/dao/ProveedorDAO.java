package dao;
import modelo.Producto;
import modelo.Proveedor;
import java.sql.SQLException;
import java.util.List;

public interface ProveedorDAO {
    int agregar(Proveedor proveedor) throws SQLException;
    Proveedor obtenerPorId(int id) throws SQLException;
    List<Proveedor> obtenerTodos() throws SQLException;
    boolean actualizar(Proveedor proveedor) throws SQLException;
    boolean eliminar(int id) throws SQLException;
}
