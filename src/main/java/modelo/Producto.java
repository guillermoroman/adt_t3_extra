package modelo;

public class Producto {
    private int id;
    private String nombre;
    private double precio;
    private int idProveedor;

    // Constructor vacío
    public Producto() {
    }

    // Constructor con todos los parámetros
    public Producto(int id, String nombre, double precio, int idProveedor) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.idProveedor = idProveedor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    // Método toString
    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", idProveedor=" + idProveedor +
                '}';
    }
}
