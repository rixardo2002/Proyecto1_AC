package es;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

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

    public void LeerConcesionario(Concesionario concesionarioBuscado) throws IOException {
        File f = new File("concesionarios.dat");
        Concesionario concesionario;
        int id;
        String nombre, localidad;
        boolean activo;
        DataInputStream dIS = new DataInputStream(new FileInputStream( f));
        try {
            while (true) {
                id = dIS.readInt();
                nombre = dIS.readUTF();
                localidad = dIS.readUTF();

                concesionario = new Concesionario(id, nombre, localidad);

                if (concesionario.equals(concesionarioBuscado)) {
                    System.out.println(concesionario.toString());
                }
            }           
        } catch (EOFException eo) {
            System.out.println("Final de fichero alcanzado.");
            dIS.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
