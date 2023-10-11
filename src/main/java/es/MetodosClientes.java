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
public class MetodosClientes {

    /**
     *
     * @author Ricardo Gómez Bastante Ricardo Gómez Ramos
     */
    public static Cliente crearCliente() throws IOException {
        Utilidades u= new Utilidades();
        String nombre=u.PedirNombre();
        String telef=u.PedirTLF();
        String ciudad=u.PedirCiudad();
        int edad=u.PedirEdad();
        String nif=u.PedirNIF();
        
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Cliente c = new Cliente(nombre, telef, ciudad, edad,nif);
        return c;
    }

    /**
     *
     * @author Ricardo Gómez Bastante
     */
    public static void clienteAFile(Cliente cliente) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        File f = new File(".\\clientes\\" + cliente.getNombre() + ".txt");//declara fichero

        boolean salir = false;

        if (!f.exists()) {
            f.createNewFile();
        } else {
            do {
                System.out.print("Dime un nuevo nombre, el tuyo ya esta usado: ");
                String nombre;
                nombre = br.readLine();

                if (!nombre.equals(cliente.getNombre())) {
                    cliente.setNombre(nombre);
                    f = new File(".\\clientes\\" + cliente.getNombre() + ".txt");
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

    public static void clienteDesdeFile() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String nombre;

        try {
            System.out.println("Dime el nombre de Cliente que estas buscando");
            nombre=br.readLine();
            File f = new File(".\\clientes\\" + nombre + ".txt");//declara fichero
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

}
