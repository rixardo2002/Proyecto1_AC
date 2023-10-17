package es;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import static es.Utilidades.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MetodosClientes {

    /**
     *
     * @author Ricardo Gómez Bastante Ricardo Gómez Ramos
     */
    public static Cliente crearCliente() throws IOException {
        Utilidades u = new Utilidades();
        String nombre = u.PedirNombre();
        String telef = u.PedirTLF();
        String ciudad = u.PedirCiudad();
        int edad = u.PedirEdad();
        String nif = u.PedirNIF();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Cliente c = new Cliente(nombre, telef, ciudad, edad, nif);
        return c;
    }

    /**
     *
     * @author Ricardo Gómez Bastante
     */
    public static void clienteAFile(Cliente cliente) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Utilidades u = new Utilidades();
        File f = new File(".\\clientes\\" + cliente.getNif() + ".txt");//declara fichero

        boolean salir = false;

        if (!f.exists()) {
            f.createNewFile();
        } else {
            do {
                System.out.print("Dime un NIF, el tuyo ya esta usado: ");
                String dni;
                dni = u.PedirNIF();

                if (!dni.equals(cliente.getNif())) {
                    cliente.setNif(dni);
                    f = new File(".\\clientes\\" + cliente.getNif() + ".txt");
                    f.createNewFile();
                    salir = true;

                }
            } while (!salir);

        }
        FileWriter fw = new FileWriter(f); //crear el flujo de salida
        fw.write(cliente.toString());
        fw.flush();
        fw.close();
    }

    /**
     *
     * @author Ricardo Gómez Ramos
     */
    public static void clienteDesdeFile() {//Lee lo que hay dentro de un fichero,nos muestra su contenido
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String dni;
        Utilidades u = new Utilidades();

        try {
            System.out.println("Dime el NIF de Cliente que estas buscando");
            dni = u.PedirNIF();
            File f = new File(".\\clientes\\" + dni + ".txt");//declara fichero
            BufferedReader fbr = new BufferedReader(new FileReader(f, StandardCharsets.UTF_8));

            String linea;

            while ((linea = fbr.readLine()) != null) {
                System.out.println(linea);
            }

            fbr.close();
        } catch (FileNotFoundException fn) {
            System.out.println("No se encuentra el fichero en la ruta indicada");
        } catch (IOException io) {
            System.out.println("Error de E/S ");
        }
    }

    /**
     *
     * @author Ricardo Gómez Ramos
     */
    public static void modificarCliente(Cliente cliente) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Utilidades u = new Utilidades();

        try {
            String dni = cliente.getNif();
            File f = new File(".\\clientes\\" + dni + ".txt");// Declara el fichero

            if (f.exists()) {
                BufferedReader fbr = new BufferedReader(new FileReader(f, StandardCharsets.UTF_8));

                String linea;
                StringBuilder clienteDatos = new StringBuilder();

                // Lee el contenido del archivo y almacena los datos en clienteData
                while ((linea = fbr.readLine()) != null) {
                    clienteDatos.append(linea).append("\n");
                }

                fbr.close();
                System.out.println("Datos actuales del cliente:");
                System.out.println(clienteDatos);

                System.out.println("Ingresa los nuevos datos (Deja en blanco para mantener los datos actuales):");

                String nuevoNombre;
                nuevoNombre = u.PedirNombre();
                cliente.setNombre(nuevoNombre);

                String nuevoTelef;
                nuevoTelef = u.PedirTLF();
                cliente.setNumeroTlf(nuevoTelef);

                String nuevaCiudad;
                nuevaCiudad = u.PedirCiudad();
                cliente.setCiudad(nuevaCiudad);

                int nuevaEdad;
                nuevaEdad = u.PedirEdad();
                cliente.setEdad(nuevaEdad);

                FileWriter fw = new FileWriter(f);
                fw.write(cliente.toString());
                fw.flush();
                fw.close();

                System.out.println("Cliente modificado con éxito");
            } else {
                System.out.println("El archivo del cliente no existe");
            }
        } catch (IOException e) {
            System.out.println("Error de E/S: " + e.getMessage());
        }
    }

    /**
     *
     * @author Ricardo Gómez Ramos
     * @param nif
     */
    public static void eliminarCliente(String nif) {
        try {
            String carpetaClientes = ".\\clientes\\" + nif + ".txt"; // Reemplaza con el nombre de tu archivo
            File archivoEliminado = new File(carpetaClientes);

            if (archivoEliminado.exists()) {
                String carpetaClientesEliminados = ".\\clientesEliminados";
                File carpetaClientesEliminadosFile = new File(carpetaClientesEliminados);

                if (!carpetaClientesEliminadosFile.exists()) {
                    carpetaClientesEliminadosFile.mkdirs();
                    System.out.println("Carpeta 'clientesEliminados' creada con éxito.");
                }

                File clienteEliminado = new File(".\\clientesEliminados\\" + nif + ".txt");
                archivoEliminado.renameTo(clienteEliminado);
            }else{
                System.out.println("El archivo cliente no existe");
            }
            }catch (Exception e) {
            System.out.println("Error al eliminar el cliente: " + e.getMessage());            
        }
        }

    }
