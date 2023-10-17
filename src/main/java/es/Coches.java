
package es;

import java.util.Arrays;

/**
 *
 * @author Julián Bastante Serrano
 */
public class Coches {
    
    public static final int TAMANIO_MARCA = 12;
    public static final int TAMANIO_MODELO = 12;
   
    public static final int TAMANIO_REGISTRO = 52;
    
    private int id;
    private char[] marca = new char[Coches.TAMANIO_MARCA];
    private char[] modelo = new char[Coches.TAMANIO_MODELO];

    public Coches(int id,char[] marca,char[] modelo) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
    }

    public Coches(int id,String marca,String modelo) {
        this.id = id;
        this.setMarca(marca);
        this.setModelo(modelo);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public char[] getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.setMarca(marca.toCharArray());
    }
    
    public void setMarca(char[] marca) {
        Arrays.fill(this.marca, (char) 0);
        for (int i = 0; i < marca.length && i < this.marca.length; i++) {
            this.marca[i] = marca[i];
        }
    }

    public char[] getModelo() {
        return modelo;
    }
    
    public void setModelo(String modelo) {
        this.setModelo(modelo.toCharArray());
    }

    public void setModelo(char[] modelo) {
        Arrays.fill(this.modelo, (char) 0);
        for (int i = 0; i < modelo.length && i < this.modelo.length; i++) {
            this.modelo[i] = modelo[i];
        }
    }
    
    
    
}
