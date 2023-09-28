package es;

/**
 *
 * @author Ricardo
 */




public class Cliente {
    
    
    //Atributos de la clase cliente
    private String nombre;
    private String numeroTlf;
    private String ciudad;
    private int edad;

    //Getter de la clase cliente
    public String getNombre() {
        return nombre;
    }

    public String getNumeroTlf() {
        return numeroTlf;
    }

    public String getCiudad() {
        return ciudad;
    }

    public int getEdad() {
        return edad;
    }
    //setter de la clase cliente

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNumeroTlf(String numeroTlf) {
        this.numeroTlf = numeroTlf;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    //Constructores, tanto vacío como completo.

    public Cliente() {
    }

    public Cliente(String nombre, String numeroTlf, String ciudad, int edad) {
        this.nombre = nombre;
        this.numeroTlf = numeroTlf;
        this.ciudad = ciudad;
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nombre=" + nombre + ", numeroTlf=" + numeroTlf + ", ciudad=" + ciudad + ", edad=" + edad + '}';
    }
    
    
    
    
}
