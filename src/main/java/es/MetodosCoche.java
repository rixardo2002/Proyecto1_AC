
package es;

import java.io.*;

/**
 *
 * @author Julián Bastante Serrano
 */
public class MetodosCoche {
    //el id se genera automaticamente cuando lo escribes el fichero
    public static void crearCoche(Coches coche) throws IOException{
        RandomAccessFile file = new RandomAccessFile(new File("coches.dat"), "rw");

        int nuevoID = (int) (file.length() / Coches.TAMANIO_REGISTRO) + 1;

        long posicion = (nuevoID - 1) * coche.TAMANIO_REGISTRO;
        file.seek(posicion);
        file.writeInt(nuevoID);
        file.write(coche.getMarcaByteArray());
        file.write(coche.getModeloByteArray());

        file.close();
    }
    
    public static void leerCoche(int id) throws IOException {

        RandomAccessFile file = new RandomAccessFile(new File("coches.dat"), "r");

        //calculo la posición donde comienza el registro
        long posicion = (id - 1) * Coches.TAMANIO_REGISTRO;
        file.seek(posicion);

        byte[] arrLeidos = new byte[Coches.TAMANIO_REGISTRO];
        file.read(arrLeidos);
        file.close();  //cerrar fichero 

        Coches coche = Coches.createCoche(arrLeidos);
        System.out.println("Coche: " + coche);
    }
}
