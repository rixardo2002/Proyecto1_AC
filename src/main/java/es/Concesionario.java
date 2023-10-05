package es;

import java.util.Arrays;

/**
 *
 * @author Julián Bastante
 */
final class Concesionario {

    public static final int TAMAÑO_REGISTRO = 66;
    public static final int TAMAÑO_NOMBRE_CONCESIONARIO = 15;
    public static final int TAMAÑO_LOCALIDAD_CONCESIONARIO = 16;
    private int id;
    private char[] nombre_concesonario = new char[Concesionario.TAMAÑO_NOMBRE_CONCESIONARIO];
    private char[] localidad_concesionario = new char[Concesionario.TAMAÑO_LOCALIDAD_CONCESIONARIO];

    public Concesionario(int id, String nombre_concesonario, String localidad_concesionario) {
        this.id = id;
        this.setNombre_concesonario(nombre_concesonario);
        this.setLocalidad_concesionario(localidad_concesionario);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_concesionario() {
        return new String(this.nombre_concesonario);
    }

    public char[] getNombre_concesionarioCharArray() {
        return nombre_concesonario;
    }

    public void setNombre_concesonario(String nombre_concesonario) {
        this.setNombre_concesionario(nombre_concesonario.toCharArray());
    }

    public void setNombre_concesionario(char[] nombre_concesonario) {
        Arrays.fill(this.nombre_concesonario, (char) 0);
        for (int i = 0; i < nombre_concesonario.length && i < this.nombre_concesonario.length; i++) {
            this.nombre_concesonario[i] = nombre_concesonario[i];
        }
    }

    public String getLocalidad_concesionario() {
        return new String(this.localidad_concesionario);
    }

    public char[] getLocalidad_concesionarioCharArray() {
        return localidad_concesionario;
    }

    public void setLocalidad_concesionario(String localidad_concesionario) {
        this.setLocalidad_concesionario(localidad_concesionario.toCharArray());
    }

    public void setLocalidad_concesionario(char[] localidad_concesionario) {
        Arrays.fill(this.localidad_concesionario, (char) 0);
        for (int i = 0; i < localidad_concesionario.length && i < this.nombre_concesonario.length; i++) {
            this.localidad_concesionario[i] = localidad_concesionario[i];
        }
    }

    @Override
    public String toString() {
        return "Concesionario{"
                + "id=" + id
                + ", nombre_concesonario=" + nombre_concesonario
                + ", localidad=" + localidad_concesionario + '}';
    }

}
