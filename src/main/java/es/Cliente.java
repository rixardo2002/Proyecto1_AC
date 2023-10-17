package es;

import java.time.LocalDate;

/**
 *
 * @author Ricardo
 */




public class Cliente {
    
    
    //Atributos de la clase cliente
    private String nombre;
    private String numeroTlf;
    private String ciudad;
    private LocalDate fechaNacimiento;// Es una fecha de nacimiento usando java.time.LocalDate, para meterlo directo a un objeto se haria
                                      // tal que asi Object obj = new Object(.....,LocalDate.of(1990,5,15)) -->Esto pondria que la fecha fue el 15 de mayo de 1990 
    private String nif;

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

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
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

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
    //Constructores, tanto vacío como completo.

    public Cliente() {
    }

    public Cliente(String nombre, String numeroTlf, String ciudad, LocalDate fechaNacimiento,String nif) {
        this.nombre = nombre;
        this.numeroTlf = numeroTlf;
        this.ciudad = ciudad;
        this.fechaNacimiento = fechaNacimiento;
        this.nif = nif;
    }

    @Override
    public String toString() {
        return nombre + "," + numeroTlf + "," + ciudad + "," + fechaNacimiento + "," + nif;
    }

    
    
    
    
    
}
