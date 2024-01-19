package dao;
import modelo.Producto;
import java.sql.SQLException;
import java.util.List;

public interface ProductoDAO {
    int agregar(Producto producto) throws SQLException;
    Producto obtenerPorId(int id) throws SQLException;
    List<Producto> obtenerTodos() throws SQLException;
    boolean actualizar(Producto producto) throws SQLException;
    boolean eliminar(int id) throws SQLException;
}
