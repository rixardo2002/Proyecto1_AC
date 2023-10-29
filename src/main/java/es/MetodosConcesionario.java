package es;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import static es.Utilidades.*;

/**
 *
 * @author Julián
 */
public class MetodosConcesionario {


    /**
     * @author Ricardo Gómez Bastante & Ricardo Gómez Ramos
     */
    public static void crearCarpetaYArchivoConcesionarios() {
        File carpeta = new File(".\\concesionarios");
        File archivo = new File(".\\concesionarios\\concesionarios.dat");

        if (!carpeta.exists()) {
            carpeta.mkdirs();  // Crea la carpeta si no existe
        }

        if (!archivo.exists()) {
            try {
                archivo.createNewFile();  // Crea el archivo si no existe
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @author Jaime & Ricardo Gómez Bastante
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static int seleccionarIDCOncesionario() throws IOException {
        File archivoConcesionarios = new File(".\\concesionarios\\concesionarios.dat");

        int lastId = 0;

        if (!archivoConcesionarios.exists()) {
            return 1; // Puedes elegir el valor inicial del ID si el archivo no existe
        }

        try (DataInputStream dIS = new DataInputStream(new FileInputStream(archivoConcesionarios))) {
            while (true) {
                int id = dIS.readInt();
                String nombre = dIS.readUTF();
                String localidad = dIS.readUTF();

                if (id > lastId) {
                    lastId = id;
                }
            }
        } catch (EOFException eof) {
            // No se hace nada aquí ya que simplemente indica el final del archivo
        }

        return lastId + 1; // Incrementa el ID
    }

    /**
     * @author Ricardo Gómez Ramos & Ricardo Gómez Bastante
     * @param concesionario
     * @throws IOException
     */
    public static void concesionarioADat(Concesionario concesionario) throws IOException {
        File archivoConcesionarios = new File(".\\concesionarios\\concesionarios.dat");

        // Utiliza FileOutputStream con modo de adición (true) para abrir el archivo
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivoConcesionarios, true))) {
            // Escribe el objeto Concesionario en el archivo
            oos.writeObject(concesionario);

            System.out.println("Concesionario creado y guardado en el archivo concesionarios.dat.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @author Jaime
     * @return
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ClassNotFoundException
     */
    public static Concesionario CrearConcesionario() throws IOException, FileNotFoundException, ClassNotFoundException {
         
        Concesionario concesionario = new Concesionario();
        concesionario.setId(seleccionarIDCOncesionario());
        concesionario.setNombreConcesionario(Utilidades.PedirNombreConcesionario());
        concesionario.setLocalidadConcesionario(Utilidades.PedirLocalidadConcesionario());
        return concesionario;

    }

    /**
     * @author Jaime
     * @param concesionario
     * @return
     * @throws IOException
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
                    concesionario.setNombreConcesionario(Utilidades.PedirNombreConcesionario());
                    break;
                case 2:
                    concesionario.setLocalidadConcesionario(Utilidades.PedirLocalidadConcesionario());
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
     * @author Ricardo Gómez Ramos & Jaime
     * @param idBuscado
     * @return
     * @throws java.io.IOException
     */
    public static Concesionario BuscarConcesionario(int idBuscado) throws IOException, ClassNotFoundException {
        File f = new File(".\\concesionarios\\concesionarios.dat");
        Concesionario concesionario;
        int id;
        String nombre, localidad;
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));

        try {
            while (true) {
               Concesionario c=(Concesionario) ois.readObject();

              //  concesionario = new Concesionario(id, nombre, localidad);

                if (c.getId() == idBuscado) {
                    return c;
                }
            }
        } catch (EOFException eo) {
            System.out.println("Final de fichero alcanzado.");
        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            ois.close();
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
            FileInputStream Fis = new FileInputStream(".\\concesionarios\\concesionarios.dat");
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
        for (Concesionario conce : concesionario) {
            if (id == conce.getId()) {
                conce.setActivo(false);
            }
        }

        try {
            FileOutputStream Fos = new FileOutputStream(".\\concesionarios\\concesionarios.dat");
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
