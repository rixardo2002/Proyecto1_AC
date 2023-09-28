package es;

/**
 *
 * @author Ricardo
 */
public class Concesionario {
    
    private int id;
    private String nombre_concesonario;
    private String localidad;

    public Concesionario(int id, String nombre_concesonario, String localidad) {
        this.id = id;
        this.nombre_concesonario = nombre_concesonario;
        this.localidad = localidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_concesonario() {
        return nombre_concesonario;
    }

    public void setNombre_concesonario(String nombre_concesonario) {
        this.nombre_concesonario = nombre_concesonario;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    @Override
    public String toString() {
        return "Concesionario{" + "id=" + id + ", nombre_concesonario=" + nombre_concesonario + ", localidad=" + localidad + '}';
    }
    
}
