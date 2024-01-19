package principal;

import baseDatos.InicializadorBD;
import dao.ProductoDAO;
import dao.ProductoDAOImpl;
import dao.ProveedorDAO;
import dao.ProveedorDAOImpl;
import modelo.Proveedor;
import modelo.Producto;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        InicializadorBD.crearTablas();
        InicializadorBD.poblarTablas();

        ProductoDAO productoDAO = new ProductoDAOImpl();
        ProveedorDAO proveedorDAO = new ProveedorDAOImpl();

        // Agregar proveedores
        try {
            Proveedor proveedor1 = new Proveedor(0, "Proveedor A", "Calle Falsa 123", "proveedorA@mail.com");
            int idProveedor1 = proveedorDAO.agregar(proveedor1);
            System.out.println("Proveedor agregado con ID: " + idProveedor1);

            Proveedor proveedor2 = new Proveedor(0, "Proveedor B", "Avenida Siempre Viva 742", "proveedorB@mail.com");
            int idProveedor2 = proveedorDAO.agregar(proveedor2);
            System.out.println("Proveedor agregado con ID: " + idProveedor2);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Agregar productos
        try {
            Producto producto1 = new Producto(0, "Producto 1", 100.0, 1);
            int idProducto1 = productoDAO.agregar(producto1);
            System.out.println("Producto agregado con ID: " + idProducto1);

            Producto producto2 = new Producto(0, "Producto 2", 200.0, 2);
            int idProducto2 = productoDAO.agregar(producto2);
            System.out.println("Producto agregado con ID: " + idProducto2);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Obtener y mostrar un proveedor
        try {
            Proveedor proveedor = proveedorDAO.obtenerPorId(1);
            if (proveedor != null) {
                System.out.println("Proveedor obtenido: " + proveedor);
            } else {
                System.out.println("Proveedor no encontrado.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Actualizar un proveedor
        try {
            Proveedor proveedor = proveedorDAO.obtenerPorId(1);
            if (proveedor != null) {
                proveedor.setDireccion("Nueva dirección");
                boolean exito = proveedorDAO.actualizar(proveedor);
                if (exito) {
                    System.out.println("Proveedor actualizado con éxito.");
                } else {
                    System.out.println("Error al actualizar proveedor.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Eliminar un proveedor
        /*
        try {
            boolean exito = proveedorDAO.eliminar(2);
            if (exito) {
                System.out.println("Proveedor eliminado con éxito.");
            } else {
                System.out.println("Error al eliminar proveedor.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

         */

    }


}
