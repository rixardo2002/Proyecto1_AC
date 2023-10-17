package es;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Julián
 */
public class MetodosConcesionario {

    Utilidades U;

    /**
     *
     * @author jaime
     */
    public Concesionario CrearConcesionario() throws IOException {

        Concesionario concesionario = new Concesionario();
        concesionario.setNombreConcesionario(U.PedirNombreConcesionario());
        concesionario.setLocalidadConcesionario(U.PedirLocalidadConcesionario());
        return concesionario;

    }

    /**
     *
     * @author jaime
     */
    public Concesionario ModificarConcesionario(Concesionario concesionario) throws IOException {
        boolean salir = false;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int opc;
        String leer;
        do {
            System.out.println("Que desea modificar??");
            System.out.println("1.Nombre del concesionario");
            System.out.println("2.Localidad del concesionario");
            System.out.println("3.salir");
            leer = br.readLine();
            opc = Integer.parseInt(leer);
            switch (opc) {
                case 1:
                    concesionario.setNombreConcesionario(U.PedirNombreConcesionario());
                    break;
                case 2:
                    concesionario.setLocalidadConcesionario(U.PedirLocalidadConcesionario());
                    break;
                case 3:
                    salir = true;

                default:
                    System.out.println("No elegiste la opcion correcta");
            }

        } while (salir);

        return concesionario;

    }

    /**
     *
     * @author Ricardo Gómez Ramos
     * @param idBuscado
     * @return
     * @throws java.io.IOException
     */
    public Concesionario BuscarConcesionario(int idBuscado) throws IOException {
        File f = new File("concesionarios.dat");
        Concesionario concesionario;
        int id;
        String nombre, localidad;
        DataInputStream dIS = new DataInputStream(new FileInputStream(f));
        try {
            while (true) {
                id = dIS.readInt();
                nombre = dIS.readUTF();
                localidad = dIS.readUTF();

                concesionario = new Concesionario(id, nombre, localidad);

                if (concesionario.getId() == idBuscado) {
                    return concesionario;
                }
            }
        } catch (EOFException eo) {
            System.out.println("Final de fichero alcanzado.");
        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            dIS.close();
        }
        return null;
    }

    /**
     * @author Ricardo Gómez Bastante
     * @param id
     */
    public void BajaConcesionario(int id) {

        ArrayList<Concesionario> concesionario = new ArrayList<>();

        try {
            FileInputStream Fis = new FileInputStream("concesionarios.dat");
            ObjectInputStream Ois = new ObjectInputStream(Fis);

            // Lee todos los objetos del archivo y guárdalos en la lista
            while (true) {
                Concesionario conce = (Concesionario) Ois.readObject();
                concesionario.add(conce);
            }
        } // Se ha llegado al final del archivo
        catch (Exception e) {
            e.printStackTrace();
        }
        for (Concesionario conce:concesionario) {
            if (id==conce.getId()) {
                conce.setActivo(false);
            }
        }
       
        try {
            FileOutputStream Fos = new FileOutputStream("concesionarios.dat");
            ObjectOutputStream Oos = new ObjectOutputStream(Fos);
            for (Concesionario conce : concesionario) {
                Oos.writeObject(conce);
            }

            Oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
