package modelo;

public class Proveedor {
    private int id;
    private String nombre;
    private String direccion;
    private String email;

    // Constructor vacío
    public Proveedor() {
    }

    // Constructor con todos los parámetros
    public Proveedor(int id, String nombre, String direccion, String email) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.email = email;
    }

    // Getters y setters

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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Método toString
    @Override
    public String toString() {
        return "Proveedor{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
