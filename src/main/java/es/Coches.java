
package es;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
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
    
    public Coches() {
    }

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
    
    public byte[] getMarcaByteArray() {
        byte[] marca_bytes = new byte[this.marca.length * 2];

        for (int i = 0; i < this.marca.length; i++) {
            marca_bytes[i * 2] = (byte) (this.marca[i] >> 8);
            marca_bytes[i * 2 + 1] = (byte) this.marca[i];
        }
        return marca_bytes;
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
    
    public void setMarca(byte[] marca) {
        CharBuffer charBuffer = ByteBuffer.wrap(marca).asCharBuffer();
        char[] chars = new char[charBuffer.remaining()];
        charBuffer.get(chars);
        this.setMarca(chars);
    }

    public char[] getModelo() {
        return modelo;
    }
    
    public byte[] getModeloByteArray() {
        byte[] modelo_bytes = new byte[this.modelo.length * 2];

        for (int i = 0; i < this.modelo.length; i++) {
            modelo_bytes[i * 2] = (byte) (this.modelo[i] >> 8);
            modelo_bytes[i * 2 + 1] = (byte) this.modelo[i];
        }
        return modelo_bytes;
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
    
    public void setModelo(byte[] modelo) {
        CharBuffer charBuffer = ByteBuffer.wrap(modelo).asCharBuffer();
        char[] chars = new char[charBuffer.remaining()];
        charBuffer.get(chars);
        this.setModelo(chars);
    }
    
    public static Coches createCoche(byte[] coche) throws IllegalArgumentException {
        int id;
        byte[] marca = new byte[Coches.TAMANIO_MARCA * 2];
        byte[] modelo = new byte[Coches.TAMANIO_MODELO * 2];

        try {
            ByteBuffer bf = ByteBuffer.wrap(coche);
            id = bf.getInt();
            bf.get(marca);
            bf.get(modelo);
        } catch (Exception e) {
            throw new IllegalArgumentException("El array pasado no puede interpretarse correctamente.\n" + e.getLocalizedMessage());
        }

        Coches c = new Coches();
        c.setId(id);
        c.setMarca(marca);
        return c;
    }
    
}
