package es;

import java.io.Serializable;


/**
 *
 * @author Julián Bastante
 */
final class Concesionario implements Serializable {

    
    private int id;
    private boolean activo;
    private String nombreConcesionario;
    private String localidadConcesionario;
    
    public Concesionario(){
        
    }

    public Concesionario(int id, String nombreConcesionario, String localidadConcesionario) {
        this.id = id;
        this.activo = true;
        this.nombreConcesionario = nombreConcesionario;
        this.localidadConcesionario = localidadConcesionario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getNombreConcesionario() {
        return nombreConcesionario;
    }

    public void setNombreConcesionario(String nombreConcesionario) {
        this.nombreConcesionario = nombreConcesionario;
    }

    public String getLocalidadConcesionario() {
        return localidadConcesionario;
    }

    public void setLocalidadConcesionario(String localidadConcesionario) {
        this.localidadConcesionario = localidadConcesionario;
    }

    @Override
    public String toString() {
        return "Concesionario:"
                + "id=" + id
                + ", nombre_concesonario=" + nombreConcesionario
                + ", localidad=" + localidadConcesionario;
    }

}
